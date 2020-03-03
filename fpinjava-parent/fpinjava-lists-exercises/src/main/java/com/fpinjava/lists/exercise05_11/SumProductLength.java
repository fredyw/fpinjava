package com.fpinjava.lists.exercise05_11;

import com.fpinjava.lists.exercise05_10.List;

public class SumProductLength {

  public static Integer sumViaFoldLeft(List<Integer> list) {
    return list.foldLeft(0, a -> b -> a + b);
  }

  public static Double productViaFoldLeft(List<Double> list) {
    return list.foldLeft(1.0, a -> b -> a * b);
  }

  public static <A> Integer lengthViaFoldLeft(List<A> list) {
    return list.foldLeft(0, a -> b -> a + 1);
  }
}
