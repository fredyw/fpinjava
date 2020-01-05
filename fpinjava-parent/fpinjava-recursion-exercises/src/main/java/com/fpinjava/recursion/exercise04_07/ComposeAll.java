package com.fpinjava.recursion.exercise04_07;

import java.util.List;

import com.fpinjava.common.CollectionUtilities;
import com.fpinjava.common.Function;

public class ComposeAll {

  public static <T> Function<T, T> composeAll(List<Function<T, T>> list) {
    return t -> {
      T result = t;
      for (Function<T, T> f : list) {
        result = f.apply(result);
      }
      return result;
    };
  }

  public static <T> Function<T, T> composeAllViaFoldLeft(List<Function<T, T>> list) {
    return t -> CollectionUtilities.foldLeft(list, t, a -> b -> b.apply(a));
  }

  public static <T> Function<T, T> composeAllViaFoldRight(List<Function<T, T>> list) {
    return t -> CollectionUtilities.foldRight(list, t, a -> b -> a.apply(b));
  }
}
