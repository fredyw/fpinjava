package com.fpinjava.recursion.exercise04_04;

import com.fpinjava.common.CollectionUtilities;
import com.fpinjava.common.TailCall;

import java.util.ArrayList;
import java.util.List;


public class Range {

  public static List<Integer> range(Integer start, Integer end) {
    return rangeTail(start, end, new ArrayList<>()).eval();
  }

  private static TailCall<List<Integer>> rangeTail(Integer start, Integer end, List<Integer> accu) {
    if (start < end) {
      return TailCall.sus(() -> rangeTail(start + 1, end, CollectionUtilities.append(accu, start)));
    }
    return TailCall.ret(accu);
  }
}
