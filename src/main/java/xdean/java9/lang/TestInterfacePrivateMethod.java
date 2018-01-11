package xdean.java9.lang;

public class TestInterfacePrivateMethod {
  public static void main(String[] args) {
    Impl impl = new Impl();
    impl.func();
    impl.worker();
    ((Inter) impl).worker();
  }

  public interface Inter {
    void func();

    private void worker() {
      System.out.println("work");
    }

    default void foo() {
      worker();
    }

    default void bar() {
      worker();
    }
  }

  public static class Impl implements Inter {
    @Override
    public void func() {
      Inter.super.worker();
    }

    private void worker() {
      Inter.super.worker();
    }
  }
}
