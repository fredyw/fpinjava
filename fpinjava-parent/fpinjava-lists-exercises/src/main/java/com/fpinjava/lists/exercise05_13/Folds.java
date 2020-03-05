package com.fpinjava.lists.exercise05_13;

import com.fpinjava.common.Function;
import com.fpinjava.lists.exercise05_10.List;

public class Folds {

  public static <A, B> B foldRightViaFoldLeft(List<A> list, B identity, Function<A, Function<B, B>> f) {
    return list.reverse().foldLeft(identity, b -> a -> f.apply(a).apply(b));
  }

  public static <A, B> B foldLeftViaFoldRight(List<A> list, B identity, Function<B, Function<A, B>> f) {
    return List.foldRight(list.reverse(), identity, b -> a -> f.apply(a).apply(b));
  }
}
