package xdean.java9.base;

import java.lang.ref.Reference;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * From OpenJDK
 */
public class TestReachabilityFence {

  static final int LOOP_ITERS = Integer.getInteger("LOOP_ITERS", 50000);
  static final int WARMUP_LOOP_ITERS = LOOP_ITERS - Integer.getInteger("GC_ITERS", 100);

  static final int MAIN_ITERS = 5;

  public static void main(String[] args) {
    boolean finalized = false;
    for (int c = 0; !finalized && c < MAIN_ITERS; c++) {
      finalized |= nonFenced();
    }
    if (!finalized) {
      throw new IllegalStateException("The object had never been finalized before timeout reached.");
    }
    finalized = false;
    for (int c = 0; !finalized && c < MAIN_ITERS; c++) {
      finalized |= fenced();
    }
    if (finalized) {
      throw new IllegalStateException("The object had been prematurely finalized.");
    }
  }

  @SuppressWarnings("unused")
  public static boolean nonFenced() {
    AtomicBoolean finalized = new AtomicBoolean();
    MyFinalizeable o = new MyFinalizeable(finalized);

    for (int i = 0; i < LOOP_ITERS; i++) {
      if (finalized.get()) {
        break;
      }
      if (i > WARMUP_LOOP_ITERS) {
        System.gc();
        System.runFinalization();
      }
    }

    return finalized.get();
  }

  public static boolean fenced() {
    AtomicBoolean finalized = new AtomicBoolean();
    MyFinalizeable o = new MyFinalizeable(finalized);
    for (int i = 0; i < LOOP_ITERS; i++) {
      if (finalized.get()) {
        break;
      }
      if (i > WARMUP_LOOP_ITERS) {
        System.gc();
        System.runFinalization();
      }
    }
    Reference.reachabilityFence(o);
    return finalized.get();
  }

  private static class MyFinalizeable {
    private final AtomicBoolean finalized;

    public MyFinalizeable(AtomicBoolean b) {
      this.finalized = b;
    }

    @Override
    protected void finalize() throws Throwable {
      finalized.set(true);
      System.out.println(this);
    }
  }
}