package io.github.felipebonezi.cipherizy.algorithm;

import static java.nio.charset.StandardCharsets.UTF_8;

import io.github.felipebonezi.cipherizy.CipherException;
import io.github.felipebonezi.cipherizy.ICipher;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * Base 32 Encoding/Decoding.
 * <p>
 * A 33-character subset of US-ASCII is used, enabling 5 bits to be
 * represented per printable character.
 * (The extra 33rd character, "=", is used to signify a special processing function.)
 * <p>
 * The Base 32 encoding is designed to represent arbitrary sequences of
 * octets in a form that needs to be case-insensitive but that need not
 * be human-readable.
 * <p>
 * See more:
 * <a href="https://datatracker.ietf.org/doc/html/rfc4648#section-6">RFC 4648 - Base 32 Encoding</a>
 */
public class Base32Cipher implements ICipher {
  
  private static final char[] ALPHABET_MAP = new char[] {
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
      'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
      'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
      'Y', 'Z', '2', '3', '4', '5', '6', '7'
  };
  
  private static final int[] HEX_ALPHABET_MAP = {
      0xFF, 0xFF, 0x1A, 0x1B, 0x1C, 0x1D, 0x1E, 0x1F,
      0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF,
      0xFF, 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06,
      0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E,
      0x0F, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16,
      0x17, 0x18, 0x19, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF,
      0xFF, 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06,
      0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E,
      0x0F, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16,
      0x17, 0x18, 0x19, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF
  };
  
  // Extra 33rd character used as pad.
  private static final char PAD = '=';
  
  private static int getNextByte(byte[] data, int j) {
    return data[j] >= 0 ? data[j] : data[j] + 256;
  }
  
  @Override
  public byte[] encrypt(byte[] key, byte[] salt, byte[] data) {
    StringBuilder builder = new StringBuilder((data.length + 7) * 8 / 5);
    int           idx     = 0;
    for (int i = 0; i < data.length; ) {
      int pos;
      int currByte = getNextByte(data, i);
      
      if (idx > 3) {
        int nextByte = 0;
        int j        = i + 1;
        if (j < data.length) {
          nextByte = getNextByte(data, j);
        }
        
        pos = currByte & (0xFF >> idx);
        idx = (idx + 5) % 8;
        pos <<= idx;
        pos |= nextByte >> (8 - idx);
        i++;
      } else {
        pos = (currByte >> (8 - (idx + 5))) & 0x1F;
        idx = (idx + 5) % 8;
        if (idx == 0) {
          i++;
        }
      }
      
      builder.append(ALPHABET_MAP[pos]);
    }
    
    while (builder.length() % 8 != 0) {
      builder.append(PAD);
    }
    
    return builder.toString().getBytes(UTF_8);
  }
  
  @Override
  public byte[] encrypt(byte[] key, byte[] salt, File data) throws CipherException {
    try {
      return encrypt(key, salt, Files.readAllBytes(data.toPath()));
    } catch (IOException e) {
      throw new CipherException("We had some problems to encrypt your data to Base32.", e);
    }
  }
  
  @Override
  public byte[] encryptFromString(byte[] key, byte[] salt, String data) {
    return encrypt(key, salt, data.getBytes(UTF_8));
  }
  
  @Override
  public byte[] decrypt(byte[] key, byte[] salt, byte[] data) {
    String encryptedText = new String(data, Charset.defaultCharset()).replace(PAD, ' ').trim();
    byte[] byteArray     = new byte[encryptedText.length() * 5 / 8];
    
    int i, index, lookup, offset, digit;
    for (i = 0, index = 0, offset = 0; i < encryptedText.length(); i++) {
      lookup = encryptedText.charAt(i) - '0';
      
      if (lookup < 0 || lookup >= HEX_ALPHABET_MAP.length) {
        continue;
      }
      
      digit = HEX_ALPHABET_MAP[lookup];
      
      if (digit == 0xFF) {
        continue;
      }
      
      if (index <= 3) {
        index = (index + 5) % 8;
        if (index == 0) {
          byteArray[offset] = (byte) (byteArray[offset] | digit);
          offset++;
          if (offset >= byteArray.length) {
            break;
          }
        } else {
          byteArray[offset] = (byte) (byteArray[offset] | digit << (8 - index));
        }
      } else {
        index = (index + 5) % 8;
        byteArray[offset] = (byte) (byteArray[offset] | (digit >>> index));
        offset++;
        
        if (offset >= byteArray.length) {
          break;
        }
        byteArray[offset] = (byte) (byteArray[offset] | digit << (8 - index));
      }
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
  public String decryptToString(byte[] key, byte[] salt, byte[] data) {
    return new String(decrypt(key, salt, data), Charset.defaultCharset());
  }
  
}
