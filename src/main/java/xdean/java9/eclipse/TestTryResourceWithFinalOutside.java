package xdean.java9.eclipse;

import java.io.Closeable;
import java.io.IOException;

class Two implements Closeable {
  @Override
  public void close() throws IOException {
  }
}

public class TestTryResourceWithFinalOutside {

  public void foo() throws IOException {
    Two t1 = new Two();
    try (t1) {
      // do something;
    }
    t1.getClass();
    // t1 = null; // Remove this code
  }

  public static void main(String[] args) {
    System.out.println("Done");
  }
}