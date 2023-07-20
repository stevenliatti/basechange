package com.botalista.basechange

import scala.annotation.tailrec

object BaseChange:
  val alphabet = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
    'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
  val digitsSize = 4

  def alphaToDecimal(s: String): Int = s.reverse
    .map(alphabet.indexOf(_))
    .zipWithIndex
    .map { case (base, exp) => (base * Math.pow(alphabet.size, exp)).toInt }
    .sum

  def decimalToAlpha(n: Int): String =
    @tailrec
    def div(n: Int, remainders: List[Int]): List[Int] =
      val quotient = n / alphabet.size
      val remainder = n % alphabet.size
      if (quotient == 0) remainder :: remainders
      else div(quotient, remainder :: remainders)

    val remainders = div(n, Nil)
    (List.fill(digitsSize - remainders.length)(0) ::: remainders)
      .map(alphabet(_))
      .mkString
