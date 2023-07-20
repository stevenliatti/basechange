package com.botalista.basechange;

import static com.botalista.basechange.BaseChange.alphaToDecimal;
import static com.botalista.basechange.BaseChange.decimalToAlpha;
import static java.util.stream.Collectors.toList;

import java.util.stream.Stream;

public class Main {
  public static void main(final String[] args) {
    final var alphas = Stream.iterate(0, i -> i + 1).map(i -> decimalToAlpha(i)).limit(500).collect(toList());
    alphas.forEach(s -> System.out.println(s));
    alphas.stream().map(s -> alphaToDecimal(s)).forEach(i -> System.out.println(i));
  }
}
