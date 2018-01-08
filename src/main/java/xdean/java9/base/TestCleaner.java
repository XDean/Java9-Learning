package xdean.java9.base;

import java.lang.ref.Cleaner;

public class TestCleaner {
  public static void main(String[] args) {
    Cleaner.create().register(new Object(), () -> System.out.println("clean"));
    System.gc();
  }
}
