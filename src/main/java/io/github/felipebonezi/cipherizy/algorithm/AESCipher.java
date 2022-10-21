package io.github.felipebonezi.cipherizy.algorithm;

import io.github.felipebonezi.cipherizy.CipherException;
import io.github.felipebonezi.cipherizy.ICipher;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Advanced Encryption Standard implementation.
 *
 * <p>
 * The Advanced Encryption Standard (AES), also known by its original name Rijndael,[3] is a specification for the encryption of electronic data established by the U.S. National Institute of Standards and Technology (NIST) in 2001.[4]
 * AES is a subset of the block cipher[3] developed by two Belgian cryptographers, Vincent Rijmen and Joan Daemen, who submitted a proposal[5] to NIST during the AES selection process.[6] Rijndael is a family of ciphers with different key and block sizes.
 * For AES, NIST selected three members of the Rijndael family, each with a block size of 128 bits, but three different key lengths: 128, 192 and 256 bits.
 * AES has been adopted by the U.S. government and is now used worldwide. It supersedes the Data Encryption Standard (DES),[7] which was published in 1977. The algorithm described by AES is a symmetric-key algorithm, meaning the same key is used for both encrypting and decrypting the data.
 * </p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Advanced_Encryption_Standard">AES - Advanced Encryption Standard.</a>
 */
class AESCipher implements ICipher {

    /**
     * Algorithm name.
     */
    private static final String AES = "AES";

    /**
     * Algorithm bit block implementation.
     */
    private static final String AES_CBC_PKCS_5_PADDING = "AES/CBC/PKCS5PADDING";

    @Override
    public byte[] encrypt(byte[] key, byte[] salt, byte[] data) throws CipherException {
        try {
            Cipher cipher = this.getCipher(key, salt, Cipher.ENCRYPT_MODE);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException
                | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            throw new CipherException("We had some problems to encrypt your data.", e);
        }
    }

    @Override
    public byte[] encryptFromString(byte[] key, byte[] salt, String data) throws CipherException {
        return this.encrypt(key, salt, data.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public byte[] decrypt(byte[] key, byte[] salt, byte[] data) throws CipherException {
        try {
            Cipher cipher = this.getCipher(key, salt, Cipher.DECRYPT_MODE);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException
                | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            throw new CipherException("We had some problems to decrypt your data.", e);
        }
    }

    @Override
    public String decryptToString(byte[] key, byte[] salt, byte[] data) throws CipherException {
        return new String(this.decrypt(key, salt, data));
    }

    /**
     * Get {@link Cipher} implementation for mode using the vector salt and master key.
     *
     * @param key        Your master key.
     * @param salt       Your vector salt key.
     * @param cipherMode Encrypt or decrypt mode.
     * @return Cipher class.
     * @throws InvalidAlgorithmParameterException Called when any invalid params are used.
     * @throws InvalidKeyException                Called when any invalid master key is used.
     * @throws NoSuchPaddingException             Called when any invalid bit block is used.
     * @throws NoSuchAlgorithmException           Called when any invalid algorithm is used.
     */
    private Cipher getCipher(byte[] key, byte[] salt, int cipherMode) throws InvalidAlgorithmParameterException,
            InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        IvParameterSpec iv = new IvParameterSpec(salt);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, AES);
        Cipher cipher = Cipher.getInstance(AES_CBC_PKCS_5_PADDING);
        cipher.init(cipherMode, secretKeySpec, iv);
        return cipher;
    }

}
