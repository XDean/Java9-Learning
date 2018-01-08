package xdean.java9.base;

import java.util.stream.IntStream;

public class TestThreadSpinWait {

  public static void main(String[] args) {
    doWithPriority(10, () -> A());
    doWithPriority(10, () -> A());
    doWithPriority(10, () -> A());
    doWithPriority(10, () -> A());
    doWithPriority(10, () -> A());
    doWithPriority(10, () -> A());
    doWithPriority(10, () -> A());
    doWithPriority(10, () -> A());
    doWithPriority(1, () -> B());
  }

  public static void doWithPriority(int priority, Runnable task) {
    Thread thread = new Thread(task);
    thread.setPriority(priority);
    thread.start();
  }

  public static void A() {
    long start = System.currentTimeMillis();
    while (System.currentTimeMillis() - start < 2000) {
      Thread.onSpinWait();
    }
    System.out.println("done");
  }

  public static void B() {
    long l = System.currentTimeMillis();
    IntStream.range(0, 1000000)
        .filter(i -> i % 100000 == 0)
        .forEach(System.out::println);
    System.out.println(System.currentTimeMillis() - l);
  }
}
