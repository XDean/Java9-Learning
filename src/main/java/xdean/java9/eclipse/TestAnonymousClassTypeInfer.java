package xdean.java9.eclipse;

public class TestAnonymousClassTypeInfer {
  @SuppressWarnings("unused")
  public static void main(String[] args) {
    Y<Integer> y1 = new Y<>() {
      @Override
      public void func() {

      }

      @Override
      public Integer get() {
        return null;
      }
    };
  }
}

interface Y<T> {
  void func();

  T get();
}