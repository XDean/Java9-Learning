package xdean.java9.base;

import java.util.stream.Stream;

public class TestStream {
  public static void main(String[] args) {
    Stream.of(1, 2, 3, 4, 5)
        .takeWhile(i -> i < 4)
        .dropWhile(i -> i < 2)
        .forEach(System.out::println);
    Stream.iterate(1, i -> i < 1000, i -> i * 2)
        .forEach(System.out::println);
  }
}
