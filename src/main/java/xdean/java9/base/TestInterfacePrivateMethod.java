package xdean.java9.base;

public class TestInterfacePrivateMethod {
  public interface I {
    void func();

    private void worker() {
    }

    default void foo() {
      worker();
    }

    default void bar() {
      worker();
    }
  }
}
