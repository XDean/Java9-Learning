package xdean.java9.base;

import static java.util.Map.entry;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class TestCollections {
  public static void main(String[] args) {
    Arrays.compare(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 });
    Arrays.mismatch(new int[] { 1, 2, 3 }, new int[] { 1, 3, 3 });
    List.of(1, 2, 3);
    Map.of(1, 2);
    Map.ofEntries(entry(1, 2), entry(3, 4));
    Set.of();
    Objects.requireNonNullElseGet(null, () -> new Object());
    Objects.checkFromIndexSize(1, 2, 3);
    Optional<Integer> o = Optional.of(1);
    o.ifPresentOrElse(i -> System.out.println(i), () -> System.out.println("empty"));
    o.or(()->Optional.of(2));
    o.stream().findFirst();
  }
}
