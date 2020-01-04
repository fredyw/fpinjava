package com.fpinjava.recursion.exercise04_02;

import com.fpinjava.common.TailCall;

import java.math.BigInteger;


public class Fibonacci {

  public static BigInteger fib(int x) {
    return fibTail(BigInteger.valueOf(x), BigInteger.ONE, BigInteger.ZERO).eval();
  }

  private static TailCall<BigInteger> fibTail(BigInteger x, BigInteger accu1, BigInteger accu2) {
    if (x.equals(BigInteger.ZERO)) {
      return TailCall.ret(x);
    }
    if (x.equals(BigInteger.ONE)) {
      return TailCall.ret(accu1.add(accu2));
    }
    return TailCall.sus(() -> fibTail(x.subtract(BigInteger.ONE), accu2, accu1.add(accu2)));
  }
}
