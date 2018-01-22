package xdean.java9.base;

import java.util.Arrays;
import java.util.List;

/**
 * Java-8: 246<br>
 * Java-9: nothing
 *
 * @see <a href="https://stackoverflow.com/questions/48221783/stream-peek-method-in-java8-vs-java9">See on
 *      stackoverflow</a>
 *
 */
public class TestStreamPeek {
  public static void main(String[] argv) throws Exception {
    List<Integer> values = Arrays.asList(1, 2, 3);
    values.stream()
        .map(n -> n * 2)
        .peek(System.out::print)
        // .filter(r->true) for java-9
        .count();
  }
}
