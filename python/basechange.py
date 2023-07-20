from functools import reduce

alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
digitsSize = 4


def alphaToDecimal(s):
    expBaseTuple = list(
        enumerate(map(lambda c: alphabet.index(c), reversed(s))))
    return reduce(lambda x, y: x + y, map(lambda t: t[1] * pow(len(alphabet), t[0]), expBaseTuple))


def decimalToAlpha(n):
    remainders = div(n, [])
    digits = [0 for x in range(digitsSize - len(remainders))] + remainders
    return reduce(lambda x, y: x + y, list(map(lambda i: alphabet[i], digits)))


def div(n, acc):
    quotient, remainder = divmod(n, len(alphabet))
    if quotient == 0:
        return [remainder] + acc
    else:
        return div(quotient, [remainder] + acc)
