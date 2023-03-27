package io.github.felipebonezi.cipherizy.algorithm;

import static java.nio.charset.StandardCharsets.UTF_8;

import io.github.felipebonezi.cipherizy.CipherException;
import io.github.felipebonezi.cipherizy.ICipher;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * The Base 64 encoding is designed to represent arbitrary sequences of
 * octets in a form that allows the use of both upper- and lowercase
 * letters but that need not be human-readable.
 * <p>
 * A 65-character subset of US-ASCII is used, enabling 6 bits to be
 * represented per printable character.  (The extra 65th character, "=",
 * is used to signify a special processing function.)
 */
public class Base64Cipher implements ICipher {
  
  private static final String   BASE64_CHARS =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
  private static final String[] BASE64_MAP   = BASE64_CHARS.split("");
  
  private static final String   BASE64_URL_SAFE_CHARS =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
  private static final String[] BASE64_URL_SAFE_MAP   = BASE64_URL_SAFE_CHARS.split("");
  
  // Extra 33rd character used as pad.
  private static final char PAD = '=';
  
  private boolean urlSafe = false;
  
  private String getChars() {
    if (urlSafe) {
      return BASE64_URL_SAFE_CHARS;
    }
    return BASE64_CHARS;
  }
  
  private String[] getCharsMap() {
    if (urlSafe) {
      return BASE64_URL_SAFE_MAP;
    }
    return BASE64_MAP;
  }
  
  public void setUrlSafe(boolean urlSafe) {
    this.urlSafe = urlSafe;
  }
  
  @Override
  public byte[] encrypt(byte[] key, byte[] salt, byte[] data) {
    // Result/Encoded string, the padding string, and the pad count.
    StringBuilder dataBuilder = new StringBuilder(new String(data, Charset.defaultCharset()));
    StringBuilder result      = new StringBuilder();
    StringBuilder padding     = new StringBuilder();
    int           padCount    = dataBuilder.length() % 3;
    
    // add a right zero pad to make this string a multiple of 3 characters.
    if (padCount > 0) {
      for (; padCount < 3; padCount++) {
        padding.append(PAD);
        dataBuilder.append("\0");
      }
    }
    
    // Increment over the length of the string, three characters at a time.
    for (padCount = 0; padCount < dataBuilder.length(); padCount += 3) {
      // We add newlines after every 76 output characters, according to the MIME specs.
      if (padCount > 0 && (padCount / 3 * 4) % 76 == 0) {
        result.append("\r\n");
      }
      
      // These three 8-bit (ASCII) characters become one 24-bit number.
      int n = (dataBuilder.charAt(padCount) << 16)
          + (dataBuilder.charAt(padCount + 1) << 8)
          + (dataBuilder.charAt(padCount + 2));
      
      // This 24-bit number gets separated into four 6-bit numbers.
      int n1 = (n >> 18) & 63, n2 = (n >> 12) & 63, n3 = (n >> 6) & 63, n4 = n & 63;
      
      // Those four 6-bit numbers are used as indices into the base64 character list.
      String[] map = getCharsMap();
      result.append(map[n1]).append(map[n2]).append(map[n3]).append(map[n4]);
    }
    
    return (result.substring(0, result.length() - padding.length()) + padding).getBytes(UTF_8);
  }
  
  @Override
  public byte[] encrypt(byte[] key, byte[] salt, File data) throws CipherException {
    try {
      return encrypt(key, salt, Files.readAllBytes(data.toPath()));
    } catch (IOException e) {
      throw new CipherException("We had some problems to encrypt your data to Base64.", e);
    }
  }
  
  @Override
  public byte[] encryptFromString(byte[] key, byte[] salt, String data) {
    return encrypt(key, salt, data.getBytes(UTF_8));
  }
  
  @Override
  public byte[] decrypt(byte[] key, byte[] salt, byte[] data) {
    // remove/ignore any characters not in the base64 characters list
    // or the pad character -- particularly newlines
    String chars = getChars();
    String encryptedTxt = new String(data, Charset.defaultCharset())
        .replaceAll("[^" + chars + "=]", "");
  
    if (encryptedTxt.isEmpty()) {
      return "".getBytes(UTF_8);
    }
  
    // replace any incoming padding with a zero pad (the 'A' character is zero).
    String p = (encryptedTxt.charAt(encryptedTxt.length() - 1) == '=' ?
                (encryptedTxt.charAt(encryptedTxt.length() - 2) == '=' ? "AA" : "A") : "");
    StringBuilder r = new StringBuilder();
    encryptedTxt = encryptedTxt.substring(0, encryptedTxt.length() - p.length()) + p;
    
    // Increment over the length of this encoded string, four characters at a time.
    for (int c = 0; c < encryptedTxt.length(); c += 4) {
      // Each of these four characters represents a 6-bit index in the
      // base64 characters list which, when concatenated, will give the
      // 24-bit number for the original 3 characters.
      int n = (chars.indexOf(encryptedTxt.charAt(c)) << 18)
          + (chars.indexOf(encryptedTxt.charAt(c + 1)) << 12)
          + (chars.indexOf(encryptedTxt.charAt(c + 2)) << 6)
          + chars.indexOf(encryptedTxt.charAt(c + 3));
      
      // Split the 24-bit number into the original three 8-bit (ASCII) characters.
      r.append((char) ((n >>> 16) & 0xFF))
          .append((char) ((n >>> 8) & 0xFF))
          .append((char) (n & 0xFF));
    }
    
    // Remove any zero pad that was added to make this a multiple of 24 bits.
    return (r.substring(0, r.length() - p.length())).getBytes(UTF_8);
  }
  
  @Override
  public File decryptToFile(byte[] key, byte[] salt, byte[] data) throws CipherException {
    byte[] decryptedBytes = decrypt(key, salt, data);
    try {
      File decryptedFile = File.createTempFile("cipherizy-decrypt", ".tmp");
      Files.write(decryptedFile.toPath(), decryptedBytes);
      decryptedFile.deleteOnExit();
      return decryptedFile;
    } catch (IOException e) {
      throw new CipherException("We had some problems to decrypt your data.", e);
    }
  }
  
  @Override
  public String decryptToString(byte[] key, byte[] salt, byte[] data) {
    return new String(decrypt(key, salt, data), Charset.defaultCharset());
  }
  
}
