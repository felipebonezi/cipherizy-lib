package io.github.felipebonezi.cipher;

/**
 * Interface used on each algorithm to encrypt or decrypt data.
 * To implement a new algorithm, you just need to implement it.
 */
public interface ICipher {

    /**
     * Encrypt your byte array using a master key and a vector salt to shuffle it.
     *
     * @param key  Your master key.
     * @param salt Your vector salt key.
     * @param data Data that you want to encrypt.
     * @return Encrypted data.
     * @throws CipherException Called when any encrypt exception was throw.
     */
    byte[] encrypt(byte[] key, byte[] salt, byte[] data) throws CipherException;

    /**
     * Encrypt from your byte array using a master key and vector salt to shuffle it.
     *
     * @param key  Your master key.
     * @param salt Your vector salt key.
     * @param data Data that you want to encrypt.
     * @return Encrypted data as text.
     * @throws CipherException Called when any encrypt exception was throw.
     */
    String encryptToString(byte[] key, byte[] salt, byte[] data) throws CipherException;

    /**
     * Decrypt your byte array using a master key and a vector salt.
     *
     * @param key  Your master key.
     * @param salt Your vector salt key.
     * @param data Data that you want to decrypt.
     * @return Decrypted data.
     * @throws CipherException Called when any decrypt exception was throw.
     */
    byte[] decrypt(byte[] key, byte[] salt, byte[] data) throws CipherException;

    /**
     * Decrypt your byte array using a master key and a vector salt.
     *
     * @param key  Your master key.
     * @param salt Your vector salt key.
     * @param data Data that you want to decrypt.
     * @return Decrypted data as text.
     * @throws CipherException Called when any decrypt exception was throw.
     */
    String decryptToString(byte[] key, byte[] salt, byte[] data) throws CipherException;

}
