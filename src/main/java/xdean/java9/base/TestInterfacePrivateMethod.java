package xdean.java9.base;

public class TestInterfacePrivateMethod {
  public static void main(String[] args) {
    Impl impl = new Impl();
//     impl.worker();
    ((Inter) impl).worker();
  }

  public interface Inter {
    void func();

    private void worker() {
      System.out.println("TestInterfacePrivateMethod.Inter.worker()");
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

    }
  }
}
