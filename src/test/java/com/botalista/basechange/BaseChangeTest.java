package com.botalista.basechange;

import static com.botalista.basechange.BaseChange.alphaToDecimal;
import static com.botalista.basechange.BaseChange.decimalToAlpha;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class BaseChangeTest extends TestCase {

  public void testZeroAtd() {
    assertEquals(0, alphaToDecimal("aaaa"));
  }

  public void testOneAtd() {
    assertEquals(1, alphaToDecimal("aaab"));
  }

  public void testEndFirstDigitAtd() {
    assertEquals(24, alphaToDecimal("aaaz"));
  }

  public void testStartSecondDigitAtd() {
    assertEquals(25, alphaToDecimal("aaba"));
  }

  public void testRandomAtd() {
    assertEquals(678, alphaToDecimal("abcd"));
  }

  public void testLaurAtd() {
    assertEquals(172366, alphaToDecimal("laur"));
  }

  public void testLastAtd() {
    assertEquals(390624, alphaToDecimal("zzzz"));
  }

  public void testZeroDta() {
    assertEquals("aaaa", decimalToAlpha(0));
  }

  public void testOneDta() {
    assertEquals("aaab", decimalToAlpha(1));
  }

  public void testEndFirstDigitDta() {
    assertEquals("aaaz", decimalToAlpha(24));
  }

  public void testStartSecondDigitDta() {
    assertEquals("aaba", decimalToAlpha(25));
  }

  public void testRandomDta() {
    assertEquals("abcd", decimalToAlpha(678));
  }

  public void testLaurDta() {
    assertEquals("laur", decimalToAlpha(172366));
  }

  public void testLastDta() {
    assertEquals("zzzz", decimalToAlpha(390624));
  }
}
