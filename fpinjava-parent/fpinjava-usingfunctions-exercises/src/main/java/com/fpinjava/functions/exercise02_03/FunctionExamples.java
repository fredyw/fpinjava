package com.fpinjava.functions.exercise02_03;


public class FunctionExamples {

  public static final Function<Integer, Function<Integer, Integer>> add = a -> b -> a + b;

  public static final BinaryOperator add2 =  a -> b -> a + b;

  public static final BinaryOperator mult =  a -> b -> a * b;
}
