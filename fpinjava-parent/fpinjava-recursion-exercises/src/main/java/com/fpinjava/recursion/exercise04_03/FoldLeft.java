package com.fpinjava.recursion.exercise04_03;

import java.util.List;

import com.fpinjava.common.CollectionUtilities;
import com.fpinjava.common.Function;
import com.fpinjava.common.TailCall;


public class FoldLeft {

  public static <T, U> U foldLeft(List<T> ts, U identity, Function<U, Function<T, U>> f) {
    return foldLeftTail(ts, identity, f).eval();
  }

  private static <T, U> TailCall<U> foldLeftTail(List<T> ts, U identity, Function<U, Function<T, U>> f) {
    if (ts.isEmpty()) {
      return TailCall.ret(identity);
    }
    return TailCall.sus(
        () -> foldLeftTail(
            CollectionUtilities.tail(ts),
            f.apply(identity).apply(CollectionUtilities.head(ts)),
            f));
  }
}
