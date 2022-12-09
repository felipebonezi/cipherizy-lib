package io.github.felipebonezi.cipherizy.algorithm;

import static java.nio.charset.StandardCharsets.UTF_8;

import io.github.felipebonezi.cipherizy.CipherException;
import io.github.felipebonezi.cipherizy.ICipher;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * Base 16 Encoding/Decoding.
 * <p>
 * A 16-character subset of US-ASCII is used, enabling 4 bits to be
 * represented per printable character.
 * <p>
 * The encoding process represents 8-bit groups (octets) of input bits
 * as output strings of 2 encoded characters.  Proceeding from left to
 * right, an 8-bit input is taken from the input data.  These 8 bits are
 * then treated as 2 concatenated 4-bit groups, each of which is
 * translated into a single character in the base 16 alphabet.
 */
class Base16Cipher implements ICipher {
  
  private final static char[] HEX_MAP = new char[] {
      '0', '1', '2', '3', '4', '5', '6', '7',
      '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
  };
  
  /**
   * Extract digit to be decoded to the right Hex value.
   *
   * @param encodedText Encoded text to Hex.
   * @param i           Index.
   *
   * @return Digit.
   */
  private static int extractDigit(String encodedText, int i) {
    int digit = encodedText.charAt(i);
    if (digit >= '0' && digit <= '9') {
      digit -= '0';
    } else if (digit >= 'A' && digit <= 'F') {
      digit -= 'A' - 10;
    }
    return digit;
  }
  
  @Override
  public byte[] encrypt(byte[] key, byte[] salt, byte[] data) {
    StringBuilder hexBuilder = new StringBuilder(data.length * 2);
    for (byte bit8 : data) {
      hexBuilder.append(HEX_MAP[(bit8 >> 4) & 0xF]);
      hexBuilder.append(HEX_MAP[bit8 & 0xF]);
    }
    return hexBuilder.toString().getBytes(UTF_8);
  }
  
  @Override
  public byte[] encrypt(byte[] key, byte[] salt, File data) throws CipherException {
    try {
      return encrypt(key, salt, Files.readAllBytes(data.toPath()));
    } catch (IOException e) {
      throw new CipherException("We had some problems to encrypt your data to Base16.", e);
    }
  }
  
  @Override
  public byte[] encryptFromString(byte[] key, byte[] salt, String data) throws CipherException {
    return encrypt(key, salt, data.getBytes(UTF_8));
  }
  
  @Override
  public byte[] decrypt(byte[] key, byte[] salt, byte[] data) {
    String encodedText = new String(data, Charset.defaultCharset());
    byte[] byteArray   = new byte[encodedText.length() / 2];
    for (int i = 0; i < byteArray.length; i++) {
      int digit1 = extractDigit(encodedText, i * 2);
      int digit2 = extractDigit(encodedText, i * 2 + 1);
      byteArray[i] = (byte) ((digit1 << 4) + digit2);
    }
    return byteArray;
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
  public String decryptToString(byte[] key, byte[] salt, byte[] data) throws CipherException {
    return new String(decrypt(key, salt, data), Charset.defaultCharset());
  }
  
}
