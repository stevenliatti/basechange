package com.botalista.basechange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BaseChange {

  public final static List<Character> alphabet = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
      'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
  public final static int digitsSize = 4;

  public static int alphaToDecimal(final String s) {
    final var reverseCharArray = Arrays.asList(reverse(s.toCharArray()));
    int sum = 0;
    for (int i = 0; i < reverseCharArray.size(); i++) {
      final int decimalValue = alphabet.indexOf(reverseCharArray.get(i));
      sum += decimalValue * Math.pow(alphabet.size(), i);
    }
    return sum;
  }

  public static String decimalToAlpha(final int n) {
    final var remainders = div(n, new ArrayList<>());
    return Stream.concat(IntStream.range(0, digitsSize - remainders.size()).map(i -> 0).mapToObj(i -> i),
        remainders.stream()).map(i -> alphabet.get(i).toString()).collect(Collectors.joining());
  }

  private static Character[] reverse(final char[] src) {
    final var copy = new Character[src.length];
    for (int i = 0; i < src.length; i++) {
      copy[i] = src[src.length - 1 - i];
    }
    return copy;
  }

  private static List<Integer> div(final int n, final List<Integer> remainders) {
    final var quotient = n / alphabet.size();
    final var remainder = n % alphabet.size();
    remainders.add(0, remainder);
    if (quotient == 0) {
      return remainders;
    } else {
      return div(quotient, remainders);
    }
  }

}
