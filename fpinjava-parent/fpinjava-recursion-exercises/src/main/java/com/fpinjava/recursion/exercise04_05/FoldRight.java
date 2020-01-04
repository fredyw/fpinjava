package com.fpinjava.recursion.exercise04_05;

import java.util.List;

import com.fpinjava.common.CollectionUtilities;
import com.fpinjava.common.Function;
import com.fpinjava.common.TailCall;

public class FoldRight {

  public static <T, U> U foldRight(List<T> ts, U identity, Function<T, Function<U, U>> f) {
    return foldRightTail(CollectionUtilities.reverse(ts), identity, f).eval();
  }

  private static <T, U> TailCall<U> foldRightTail(List<T> ts,
                                                  U identity,
                                                  Function<T, Function<U, U>> f) {
    if (ts.isEmpty()) {
      return TailCall.ret(identity);
    }
    return TailCall.sus(
        () -> foldRightTail(
            CollectionUtilities.tail(ts),
            f.apply(CollectionUtilities.head(ts)).apply(identity),
            f));
  }
}
