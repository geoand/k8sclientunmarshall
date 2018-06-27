package com.example;

import static junit.framework.TestCase.assertNotNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.v3_2.KubernetesResource;
import io.fabric8.kubernetes.clnt.v3_2.utils.Serialization;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.junit.Test;

public class K8sClient32Test {

  private static final String FILE = "test-kubernetes.json";

  @Test
  public void readerFor() throws IOException {
    new ObjectMapper().readerFor(io.fabric8.kubernetes.api.model.v3_2.KubernetesResource.class).readValue(inputStream());
  }

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