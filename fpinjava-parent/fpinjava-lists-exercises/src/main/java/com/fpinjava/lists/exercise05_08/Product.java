package com.fpinjava.lists.exercise05_08;

import com.fpinjava.common.TailCall;
import com.fpinjava.lists.exercise05_06.List;

public class Product {

  public static Double product(List<Double> ints) {
    return product(ints, 1).eval();
  }

  private static TailCall<Double> product(List<Double> list, double acc) {
    if (list.isEmpty()) {
      return TailCall.ret(acc);
    }
    return product(list.tail(), list.head() * acc);
  }
}
