# cipherizy-lib

[![CI](https://github.com/felipebonezi/cipherizy-lib/actions/workflows/continouos-integration.yml/badge.svg)](https://github.com/felipebonezi/cipherizy-lib/actions/workflows/continouos-integration.yml)
[![Renovate](https://img.shields.io/badge/renovate-enabled-brightgreen.svg)](https://renovatebot.com)
[![Version](https://img.shields.io/github/v/release/felipebonezi/cipherizy-lib?logo=java)](https://github.com/felipebonezi/cipherizy-lib/releases)
[![CLA assistant](https://cla-assistant.io/readme/badge/felipebonezi/cipherizy-lib)](https://cla-assistant.io/felipebonezi/cipherizy-lib)
[![Licence](https://img.shields.io/github/license/felipebonezi/cipherizy-lib?color=blue)](https://github.com/felipebonezi/cipherizy-lib/blob/main/LICENSE)

Cipher lib for Java, Kotlin or Scala projects.

This lib was developed with the main goal of make sensitive data encryption/decryption easy. To use, you need only to import it into your project using maven, gradle or sbt.

## Getting Started

Import into your project.

### Maven

```xml
<dependency>
 <groupId>io.github.felipebonezi</groupId>
 <artifactId>cipherizy-lib</artifactId>
 <version>X.Y.Z</version>
 <type>pom</type>
</dependency>
```

### Gradle

```gradle
implementation 'io.github.felipebonezi:cipherizy-lib:X.Y.Z'
```

### Sbt

```sbt
  libraryDependencies ++= "io.github.felipebonezi" % "cipherizy-lib" % "X.Y.Z"
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
  byte[] key  = getKey();  // Generate your own randomic key (must be 32 bytes long).
  byte[] salt = getSalt(); // Get your encryption salt (must be 16 bytes long).
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
  byte[] key  = getKey();  // Get your encryption key (must be 32 bytes long).
  byte[] salt = getSalt(); // Get yor encryption salt (must be 16 bytes long).
  byte[] data = getData(); // Get your encrypted data in byte[] format.
  
  byte[] decrypted = cipher.decrypt(key, salt, data);
  System.out.println(new String(decrypted))
} catch (CipherException e) {
  // There was an error to decrypt your data.
  e.printStackTrace();
}
```
