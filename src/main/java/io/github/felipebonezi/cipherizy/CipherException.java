package io.github.felipebonezi.cipherizy;

/**
 * All exceptions are grouped at the class.
 * You can access the real exception beyond the getCause() method.
 */
public class CipherException extends Throwable {

    public CipherException(String message, Throwable cause) {
        super(message, cause);
    }

}
