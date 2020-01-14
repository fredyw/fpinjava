package com.fpinjava.recursion.exercise04_09;

import com.fpinjava.common.CollectionUtilities;
import com.fpinjava.common.TailCall;

import java.math.BigInteger;
import java.util.List;


public class Memoization {

  public static String fibo(int number) {
    List<BigInteger> list =
        fibTail(BigInteger.valueOf(number), BigInteger.ONE, BigInteger.ZERO,
            CollectionUtilities.list(BigInteger.ZERO)).eval();
    return makeString(list, ", ");
  }

  private static TailCall<List<BigInteger>> fibTail(BigInteger x,
                                                    BigInteger accu1,
                                                    BigInteger accu2,
                                                    List<BigInteger> accu) {
    if (x.equals(BigInteger.ZERO)) {
      return TailCall.ret(accu);
    }
    if (x.equals(BigInteger.ONE)) {
      return TailCall.ret(CollectionUtilities.append(accu, accu1.add(accu2)));
    }
    return TailCall.sus(() ->
        fibTail(x.subtract(BigInteger.ONE), accu2, accu1.add(accu2),
            CollectionUtilities.append(accu, accu1.add(accu2))));
  }

  public static <T> String makeString(List<T> list, String separator) {
    if (list.isEmpty()) {
      return "";
    }
    if (CollectionUtilities.tail(list).isEmpty()) {
      return CollectionUtilities.head(list).toString();
    }
    return CollectionUtilities.head(list) +
        CollectionUtilities.foldLeft(CollectionUtilities.tail(list), "", x -> y -> x + separator + y);
  }
}
