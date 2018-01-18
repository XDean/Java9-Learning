package xdean.java9;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class TestJava9 {
  public static void main(String[] args) {
    CompletableFuture.supplyAsync(()->1)
    .completeOnTimeout(2, 100, TimeUnit.MILLISECONDS)
    .thenAccept(System.out::println)
    ;
  }
}
