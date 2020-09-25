package com.pair;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A simple pair class. It contains two values, called {@link #first} and {@link #second}, with
 * getters and setters for both of them. It also contains a constructor which takes in no values,
 * and two values. The no value constructor sets both values to null, and the two-argument
 * constructor sets the values of both values. There is also a builder, which can be used like this:
 * {@code Pair.builder().first(1).second(2).build}. The {@link #toString()}, {@link
 * #equals(Object)}, and {@link #hashCode()} method are provided.
 *
 * @param <K> The type for the first value.
 * @param <V> The type for the second value.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pair<K, V> {
  /** The first value. */
  public K first;
  /** The second value. */
  public V second;
}