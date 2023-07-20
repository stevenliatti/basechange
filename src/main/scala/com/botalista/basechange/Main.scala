package com.botalista.basechange

import BaseChange.decimalToAlpha
import BaseChange.alphaToDecimal

@main def main: Unit =
  val alphas = 0 until 500 map decimalToAlpha
  alphas foreach println
  alphas map alphaToDecimal foreach println
