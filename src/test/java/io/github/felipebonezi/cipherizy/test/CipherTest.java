package io.github.felipebonezi.cipherizy.test;

import io.github.felipebonezi.cipherizy.algorithm.CipherFactory;
import org.junit.Assert;
import org.junit.Test;

public class CipherTest {
  
  @Test
  public void whenFactoryIsInstantiated_thenIsSingleton() {
    CipherFactory singleton1    = CipherFactory.getInstance();
    int           hashCodeInst1 = singleton1.hashCode();
    Assert.assertNotNull(singleton1);
    
    CipherFactory singleton2    = CipherFactory.getInstance();
    int           hashCodeInst2 = singleton2.hashCode();
    Assert.assertNotNull(singleton2);
    
    Assert.assertEquals(hashCodeInst1, hashCodeInst2);
  }
  
}
