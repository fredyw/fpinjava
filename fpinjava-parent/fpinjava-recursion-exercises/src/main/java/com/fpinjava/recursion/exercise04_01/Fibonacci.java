package com.fpinjava.recursion.exercise04_01;

import java.math.BigInteger;

public class Fibonacci {
  
  public static BigInteger fib(int x) {
    return fibTail(BigInteger.valueOf(x), BigInteger.ONE, BigInteger.ZERO);
  }

  private static BigInteger fibTail(BigInteger x, BigInteger accu1, BigInteger accu2) {
    if (x.equals(BigInteger.ZERO)) {
      return x;
    }
    if (x.equals(BigInteger.ONE)) {
      return accu1.add(accu2);
    }
    return fibTail(x.subtract(BigInteger.ONE), accu2, accu1.add(accu2));
  }
}
