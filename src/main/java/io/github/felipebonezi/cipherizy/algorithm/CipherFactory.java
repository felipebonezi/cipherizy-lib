package io.github.felipebonezi.cipherizy.algorithm;

import io.github.felipebonezi.cipherizy.ICipher;
import java.security.Provider;
import java.security.Security;

/**
 * Factory method pattern to generate {@link ICipher} implementations to encrypt or decrypt some data.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Factory_method_pattern">Factory Pattern</a>
 */
public class CipherFactory {

    /** Synchronized helper locker to avoid parallelism. */
    private static final String LOCK = "CipherFactory::LOCK";

    /**
     * Singleton factory instance.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Singleton_pattern">The Singleton Pattern</a>
     */
    private static CipherFactory INSTANCE;
    
    private CipherFactory() {
    }

    /**
     * Get {@link ICipher} implement based on an {@link Algorithm}.
     *
     * @param algorithm Algorithm implementation.
     *
     * @return Cipher implementation.
     */
    public ICipher get(Algorithm algorithm) {
        switch (algorithm) {
            case AES:
                return new AESCipher();
            case BASE16:
                return new Base16Cipher();
            case BASE32:
                return new Base32Cipher();
            case BASE64:
                return new Base64Cipher();
        }
        throw new IllegalArgumentException("Algorithm not implement.");
    }

    /**
     * Get factory instance.
     *
     * @return Factory instance.
     */
    public static CipherFactory getInstance() {
        synchronized (LOCK) {
            if (INSTANCE == null) {
                INSTANCE = new CipherFactory();
            }
            return INSTANCE;
        }
    }
    
    /**
     * Designed to use a provider-based architecture, the JCE allows for qualified cryptography
     * libraries such as BouncyCastle to be plugged in as security providers and new algorithms
     * to be added seamlessly.
     * <p>
     * We can add a security provider either statically or dynamically.
     * To add a new Provider statically, we modify the `java.security` file located in
     * <JAVA_HOME>/jre/lib/security folder.
     * <p>
     * We add the line at the end of the list:
     * security.provider.4=com.sun.net.ssl.internal.ssl.Provider
     * security.provider.5=com.sun.crypto.provider.SunJCE
     * security.provider.6=sun.security.jgss.SunProvider
     * security.provider.7=org.bouncycastle.jce.provider.BouncyCastleProvider
     *
     * @param provider       Required security provider.
     * @param otherProviders Optional security providers.
     */
    public void addSecurityProviders(Provider provider, Provider... otherProviders) {
        Security.addProvider(provider);
        if (otherProviders != null && otherProviders.length > 0) {
            for (Provider otherProvider : otherProviders) {
                Security.addProvider(otherProvider);
            }
        }
    }
    
    /** Algorithms. */
    public enum Algorithm {
        AES,
        BASE16,
        BASE32,
        BASE64
    }
    
}
