import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vc.com.justa.cipher.CipherException;
import vc.com.justa.cipher.ICipher;
import vc.com.justa.cipher.algorithm.CipherFactory;

import java.nio.charset.StandardCharsets;

public class CipherTest {

    private static final String CREDIT_CARD_NUMBER_16 = "6516600011112222";
    private static final String CREDIT_CARD_NUMBER_22 = "6062000011112222333355";
    private static final byte[] KEY = "0029959810000151".getBytes(StandardCharsets.UTF_8);
    private static final byte[] SALT = "JUSTA-PAGAMENTOS".getBytes(StandardCharsets.UTF_8);

    private ICipher cipher;

    @Before
    public void before() {
        CipherFactory factory = CipherFactory.getInstance();
        this.cipher = factory.get(CipherFactory.Algorithm.AES);
    }

    @Test
    public void checkKeyAndSaltInputLength() {
        Assert.assertEquals(0, KEY.length % 8);
        Assert.assertEquals(0, SALT.length % 8);
    }

    @Test
    public void whenEncryptData16_thenDecryptSameData() throws CipherException {
        byte[] data = CREDIT_CARD_NUMBER_16.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedData = this.cipher.encrypt(KEY, SALT, data);
        Assert.assertEquals(0, encryptedData.length % 16);

        byte[] decryptedData = this.cipher.decrypt(KEY, SALT, encryptedData);
        Assert.assertArrayEquals(data, decryptedData);
    }

    @Test
    public void whenEncryptData22_thenDecryptSameData() throws CipherException {
        byte[] data = CREDIT_CARD_NUMBER_22.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedData = this.cipher.encrypt(KEY, SALT, data);
        Assert.assertEquals(0, encryptedData.length % 16);

        byte[] decryptedData = this.cipher.decrypt(KEY, SALT, encryptedData);
        Assert.assertArrayEquals(data, decryptedData);
    }

}
