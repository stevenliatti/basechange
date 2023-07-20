package com.botalista.basechange

import BaseChange.alphaToDecimal
import BaseChange.decimalToAlpha

class BaseChangeTest extends munit.FunSuite:

  test("Alpha to decimal: zero")(assertEquals(alphaToDecimal("aaaa"), 0))
  test("Alpha to decimal: one")(assertEquals(alphaToDecimal("aaab"), 1))
  test("Alpha to decimal: end first digit")(
    assertEquals(alphaToDecimal("aaaz"), 24)
  )
  test("Alpha to decimal: start second digit")(
    assertEquals(alphaToDecimal("aaba"), 25)
  )
  test("Alpha to decimal: random")(assertEquals(alphaToDecimal("abcd"), 678))
  test("Alpha to decimal: laur")(assertEquals(alphaToDecimal("laur"), 172366))
  test("Alpha to decimal: last")(assertEquals(alphaToDecimal("zzzz"), 390624))

  test("Decimal to alpha: zero")(assertEquals(decimalToAlpha(0), "aaaa"))
  test("Decimal to alpha: one")(assertEquals(decimalToAlpha(1), "aaab"))
  test("Decimal to alpha: end first digit")(
    assertEquals(decimalToAlpha(24), "aaaz")
  )
  test("Decimal to alpha: start second digit")(
    assertEquals(decimalToAlpha(25), "aaba")
  )
  test("Decimal to alpha: random")(assertEquals(decimalToAlpha(678), "abcd"))
  test("Decimal to alpha: laur")(assertEquals(decimalToAlpha(172366), "laur"))
  test("Decimal to alpha: last")(assertEquals(decimalToAlpha(390624), "zzzz"))
