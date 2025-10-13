package java.util;

import java.util.function.*;

@FunctionalInterface
public interface Comparator<T> {
    
    // Main method to implement
    int compare(T o1, T o2);

    // Optional override
    boolean equals(Object obj);

    // Default method: reverse order
    default Comparator<T> reversed() {
        return (o1, o2) -> compare(o2, o1);
    }

    // Default method: chain comparator
    default Comparator<T> thenComparing(Comparator<? super T> other) {
        Objects.requireNonNull(other);
        return (c1, c2) -> {
            int res = compare(c1, c2);
            return (res != 0) ? res : other.compare(c1, c2);
        };
    }

    // thenComparing using key extractor
    default <U> Comparator<T> thenComparing(Function<? super T, ? extends U> keyExtractor,
                                            Comparator<? super U> keyComparator) {
        return thenComparing(comparing(keyExtractor, keyComparator));
    }

    // thenComparing using natural order of key
    default <U extends Comparable<? super U>> Comparator<T> thenComparing(Function<? super T, ? extends U> keyExtractor) {
        return thenComparing(comparing(keyExtractor));
    }

    // thenComparing for primitive int
    default Comparator<T> thenComparingInt(ToIntFunction<? super T> keyExtractor) {
        return thenComparing(comparingInt(keyExtractor));
    }

    // thenComparing for primitive long
    default Comparator<T> thenComparingLong(ToLongFunction<? super T> keyExtractor) {
        return thenComparing(comparingLong(keyExtractor));
    }

    // thenComparing for primitive double
    default Comparator<T> thenComparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        return thenComparing(comparingDouble(keyExtractor));
    }

    // Static method: natural order
    public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return (o1, o2) -> o1.compareTo(o2);
    }

    // Static method: reverse order
    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        return (o1, o2) -> o2.compareTo(o1);
    }

    // Static method: nullsFirst
    public static <T> Comparator<T> nullsFirst(Comparator<? super T> comparator) {
        return (o1, o2) -> {
            if (o1 == null) return (o2 == null) ? 0 : -1;
            if (o2 == null) return 1;
            return comparator.compare(o1, o2);
        };
    }

    // Static method: nullsLast
    public static <T> Comparator<T> nullsLast(Comparator<? super T> comparator) {
        return (o1, o2) -> {
            if (o1 == null) return (o2 == null) ? 0 : 1;
            if (o2 == null) return -1;
            return comparator.compare(o1, o2);
        };
    }

    // Static method: comparing with key extractor
    public static <T, U> Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor,
                                                 Comparator<? super U> keyComparator) {
        Objects.requireNonNull(keyExtractor);
        Objects.requireNonNull(keyComparator);
        return (c1, c2) -> keyComparator.compare(keyExtractor.apply(c1), keyExtractor.apply(c2));
    }

    // comparing with Comparable key
    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }

    // comparingInt
    public static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor) {
        return (c1, c2) -> Integer.compare(keyExtractor.applyAsInt(c1), keyExtractor.applyAsInt(c2));
    }

    // comparingLong
    public static <T> Comparator<T> comparingLong(ToLongFunction<? super T> keyExtractor) {
        return (c1, c2) -> Long.compare(keyExtractor.applyAsLong(c1), keyExtractor.applyAsLong(c2));
    }

    // comparingDouble
    public static <T> Comparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        return (c1, c2) -> Double.compare(keyExtractor.applyAsDouble(c1), keyExtractor.applyAsDouble(c2));
    }
}