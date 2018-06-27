package com.example;

import static junit.framework.TestCase.assertNotNull;

import io.fabric8.kubernetes.clnt.v3_1.utils.Serialization;
import java.io.InputStream;
import java.util.Map;
import org.junit.Test;

public class K8sClient31Test {

  private static final String FILE = "test-kubernetes.json";

  @Test
  public void unmashallList() {
    final Object o = Serialization.unmarshal(inputStream(), (Map) null);
    assertNotNull(o);
  }

  private InputStream inputStream() {
    final InputStream result = this.getClass().getResourceAsStream("/" + FILE);
    if (result == null) {
      throw new RuntimeException("Unable to locate classpath resource:" + FILE);
    }
    return result;
  }

}
