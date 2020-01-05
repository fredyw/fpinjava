package com.fpinjava.recursion.exercise04_08;

import java.util.List;

import com.fpinjava.common.CollectionUtilities;
import com.fpinjava.common.Function;


public class ComposeAll {

  static <T> Function<T, T> composeAllViaFoldLeft(List<Function<T, T>> list) {
    return t -> CollectionUtilities.foldLeft(CollectionUtilities.reverse(list), t, a -> b -> b.apply(a));
  }

  static <T> Function<T, T> composeAllViaFoldRight(List<Function<T, T>> list) {
    return t -> CollectionUtilities.foldRight(list, t, a -> b -> a.apply(b));
  }

  static <T> Function<T, T> andThenAllViaFoldLeft(List<Function<T, T>> list) {
    return t -> CollectionUtilities.foldLeft(list, t, a -> b -> b.apply(a));
  }

  static <T> Function<T, T> andThenAllViaFoldRight(List<Function<T, T>> list) {
    return t -> CollectionUtilities.foldRight(CollectionUtilities.reverse(list), t, a -> b -> a.apply(b));
  }
}
