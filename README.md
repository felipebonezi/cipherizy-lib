# cipherizy-lib

Cipher lib for Java, Kotlin or Scala projects.

This lib was developed with the main goal of make sensitive data encryption/decryption easy. To use, you need only to import it into your project using maven, gradle or sbt.

## Getting Started

### Maven

```xml
<dependency>
 <groupId>io.github.felipebonezi</groupId>
 <artifactId>cipherizy-lib</artifactId>
 <version>1.0.0</version>
 <type>pom</type>
</dependency>
```

### Gradle

```gradle
implementation 'io.github.felipebonezi:cipherizy-lib:1.0.0'
```

### Sbt

```sbt
  libraryDependencies ++= "io.github.felipebonezi" % "cipherizy-lib" % "1.0.0"
```

## First Cipher

It is too easy to encrypt and decrypt data using this lib.

There is a factory class - i.e. `CipherFactory` - that creates the encription classes who will be responsible to generade the algorythns.

There is a cipher interface - i.e. `ICipher`- that you will use to encript your data in different algorithms (e.g. AES).

### Encrypt

```java
CipherFactory factory = CipherFactory.getIntance();
ICipher cipher = factory.get(CipherFactory.Algorithm.AES);

// To encrypt your data.
try {
  byte[] key  = getKey();  // Generate yout own randomic key.
  byte[] salt = getSalt(); // Get yor encryption salt.
  byte[] data = getData(); // Get your data in byte[] format.
  
  byte[] encrypted = cipher.encrypt(key, salt, data);
  System.out.println(new String(encrypted))
} catch (CipherException e) {
  // There was an error to encrypt your data.
  e.printStackTrace();
}
```

### Decrypt

```java
CipherFactory factory = CipherFactory.getIntance();
ICipher cipher = factory.get(CipherFactory.Algorithm.AES);

// To decrypt your data.
try {
  byte[] key  = getKey();  // Get your encryption key.
  byte[] salt = getSalt(); // Get yor encryption salt.
  byte[] data = getData(); // Get your encrypted data in byte[] format.
  
  byte[] decrypted = cipher.decrypt(key, salt, data);
  System.out.println(new String(decrypted))
} catch (CipherException e) {
  // There was an error to decrypt your data.
  e.printStackTrace();
}
```
