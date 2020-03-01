package com.fpinjava.lists.exercise05_07;

import com.fpinjava.common.TailCall;
import com.fpinjava.lists.exercise05_06.List;

public class Sum {

  public static Integer sum(List<Integer> ints) {
    return sum(ints, 0).eval();
  }

  private static TailCall<Integer> sum(List<Integer> ints, int acc) {
    if (ints.isEmpty()) {
      return TailCall.ret(acc);
    }
    return sum(ints.tail(), acc + ints.head());
  }
}
