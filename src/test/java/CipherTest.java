import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vc.com.justa.cipher.CipherException;
import vc.com.justa.cipher.ICipher;
import vc.com.justa.cipher.algorithm.CipherFactory;

import java.nio.charset.StandardCharsets;

/**
 * Cipher class test.
 */
public class CipherTest {

    /**
     * Credit card number with 16 chars.
     */
    private static final String CREDIT_CARD_NUMBER_16 = "6516600011112222";

    /**
     * Credit card number with 22 chars.
     */
    private static final String CREDIT_CARD_NUMBER_22 = "6062000011112222333355";

    /**
     * Master key used in encryption and decryption mode.
     * 16 bytes = 128 bits.
     */
    private static final byte[] KEY = "0029959810000151".getBytes(StandardCharsets.UTF_8);

    /**
     * Vector salt used in encryption and decryption mode.
     * 16 bytes = 128 bits.
     */
    private static final byte[] SALT = "JUSTA-PAGAMENTOS".getBytes(StandardCharsets.UTF_8);

    /**
     * Test with the master key and vector salt has input length divisible by 8.
     */
    @Test
    public void checkKeyAndSaltInputLength() {
        Assert.assertEquals(0, KEY.length % 8);
        Assert.assertEquals(0, SALT.length % 8);
    }

    /**
     * When we encrypt data with AES algorithm for 16 inputs length, then we expect decrypt data are the same.
     *
     * @throws CipherException Throw when we've problems to instantiate {@link ICipher} or encrypt data.
     */
    @Test
    public void whenAESEncryptData16_thenDecryptSameData() throws CipherException {
        CipherFactory factory = CipherFactory.getInstance();
        ICipher cipherAES = factory.get(CipherFactory.Algorithm.AES);

        byte[] data = CREDIT_CARD_NUMBER_16.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedData = cipherAES.encrypt(KEY, SALT, data);
        Assert.assertEquals(0, encryptedData.length % 16);

        byte[] decryptedData = cipherAES.decrypt(KEY, SALT, encryptedData);
        Assert.assertArrayEquals(data, decryptedData);
    }

    /**
     * When we encrypt data with AES algorithm for 22 inputs length, then we expect decrypt data are the same.
     *
     * @throws CipherException Throw when we've problems to instantiate {@link ICipher} or encrypt data.
     */
    @Test
    public void whenAESEncryptData22_thenDecryptSameData() throws CipherException {
        CipherFactory factory = CipherFactory.getInstance();
        ICipher cipherAES = factory.get(CipherFactory.Algorithm.AES);

        byte[] data = CREDIT_CARD_NUMBER_22.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedData = cipherAES.encrypt(KEY, SALT, data);
        Assert.assertEquals(0, encryptedData.length % 16);

        byte[] decryptedData = cipherAES.decrypt(KEY, SALT, encryptedData);
        Assert.assertArrayEquals(data, decryptedData);
    }

}
