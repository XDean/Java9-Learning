package xdean.java9.base;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.Arrays;

public class TestVarHandle {
  public static void main(String[] args) throws Exception {
    mode();
  }

  private static void mode() throws Exception {
    Bean b = new Bean();
    VarHandle iHandle = MethodHandles.privateLookupIn(Bean.class, MethodHandles.lookup())
        .findVarHandle(Bean.class, "i", int.class);
    iHandle.setOpaque(b, 2);
    System.out.println(b.getI());
  }

  @SuppressWarnings("unused")
  private static void array() {
    String[] sa = new String[10];
    VarHandle avh = MethodHandles.arrayElementVarHandle(String[].class);
    System.out.println(avh);
    // JsonPrinter.getDefault().println(avh, System.out);
    System.out.println(avh.varType());
    System.out.println(avh.coordinateTypes());
    System.out.println(Arrays.toString(sa));
    avh.compareAndSet(sa, 5, null, "new");
    System.out.println(Arrays.toString(sa));
  }
}