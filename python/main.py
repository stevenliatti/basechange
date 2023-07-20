from basechange import decimalToAlpha
from basechange import alphaToDecimal

def main():
    alphas = list(map(lambda i: decimalToAlpha(i), range(500)))
    for a in alphas:
        print(a)

    decimals = map(lambda s: alphaToDecimal(s), alphas)
    for d in decimals:
        print(d)

if __name__ == "__main__":
    main()
