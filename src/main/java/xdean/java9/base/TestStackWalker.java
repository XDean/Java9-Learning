package xdean.java9.base;

import java.lang.StackWalker.Option;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class TestStackWalker {
  public static void main(String[] args) {
    simple();
    reflect();
    forLambda();
    privateAccess();
  }

  private static StackWalker instance = StackWalker.getInstance(Set.of(
      Option.RETAIN_CLASS_REFERENCE
  // Option.SHOW_REFLECT_FRAMES
  // Option.SHOW_HIDDEN_FRAMES
  ));

  public static void printStack() {
    instance
        .walk(s -> s.collect(Collectors.toList()))
        .stream()
        .forEach(sf -> System.out.println(sf.getDeclaringClass() + "\t" + sf));
  }

  public static void simple() {
    System.out.println("TestStackWalker.simple()");
    printStack();
  }

  public static void reflect() {
    System.out.println("TestStackWalker.forReflect()");
    try {
      TestStackWalker.class.getMethod("printStack").invoke(null);
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
        | NoSuchMethodException | SecurityException e) {
      e.printStackTrace();
    }
  }

  public static void forLambda() {
    System.out.println("TestStackWalker.forLambda()");
    Arrays.asList(1).forEach(i -> printStack());
  }

  public static void privateAccess() {
    System.out.println("TestStackWalker.privateAccess()");
    PrivateAccess.func();
  }

  private static class PrivateAccess {
    private static void func() {
      TestStackWalker.printStack();
    }
  }
}
