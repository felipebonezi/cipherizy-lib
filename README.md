# jst-cipher-lib
[Justa Pagamentos](https://www.justa.com.vc) cipher lib for Java or Kotlin projects.

The so called "the one with criptography", this lib was developed with the main goal of make sensitive data encryption easy for the developers of  Justa Pagamentos. 

To use it, the only thing you need to do is import it into your project using gradle or maven.

## Getting Started

### Maven

Insert this block into your pom.xml file
```xml
colocar dependencia maven zqui
```


### Gradle

Insert this block into your build.gradle file
```gradle
colocar dependencia gradle aqui
```


## First Cipher

It is too easy to encrypt and decrypt data using this lib.

There is a factory class ( CipherFactory ) that creates the encription classes who will be responsible to generade the algorythns.

There is a cipher interface ( ICipher ) that you will use to encript your data in different algorithms (AES, for exmple.).

#### Encrypt
```java
CipherFactory factory = CipherFactory.getIntance();
ICipher cipher = factory.get(CipherFactory.Algorithm.AES);

// To encrypt yout data
try {
  byte[] key  = generateKey(); // Generate yout own randomic key
  byte[] salt = generateSalt(); // Generate yout own randomic salt tp be applyed in your message
  byte[] data = getData(); // Get your data in byte[] format
    byte[] encrypted = cipher.encrypt(key, salt, data);
  System.out.println(new String(encrypted))
} catch (CipherException e) {
  // There was an error encrypting your data
  e.printStackTrace();
}
```

#### Decrypt
```java
CipherFactory factory = CipherFactory.getIntance();
ICipher cipher = factory.get(CipherFactory.Algorithm.AES);

// To decrypt yout data
try {
  byte[] key  = getKey(); // Get your encryption key
  byte[] salt = getSalt(); // Get yor encryption salt
  byte[] data = getData(); // Get your encrypted data in byte[] format
    byte[] decrypted = cipher.decrypt(key, salt, data);
  System.out.println(new String(decrypted))
} catch (CipherException e) {
  // There was an error decrypting your data
  e.printStackTrace();
}
```