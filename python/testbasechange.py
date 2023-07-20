import unittest
import basechange


class TestBaseChange(unittest.TestCase):
    def test_zero_atd(self):
        self.assertEqual(basechange.alphaToDecimal('aaaa'), 0)

    def test_one_atd(self):
        self.assertEqual(basechange.alphaToDecimal('aaab'), 1)

    def test_end_first_digit_atd(self):
        self.assertEqual(basechange.alphaToDecimal('aaaz'), 24)

    def test_start_second_digit_atd(self):
        self.assertEqual(basechange.alphaToDecimal('aaba'), 25)

    def test_random_atd(self):
        self.assertEqual(basechange.alphaToDecimal('abcd'), 678)

    def test_laur_atd(self):
        self.assertEqual(basechange.alphaToDecimal('laur'), 172366)

    def test_last_atd(self):
        self.assertEqual(basechange.alphaToDecimal('zzzz'), 390624)

    def test_zero_dta(self):
        self.assertEqual(basechange.decimalToAlpha(0), 'aaaa')

    def test_one_dta(self):
        self.assertEqual(basechange.decimalToAlpha(1), 'aaab')

    def test_end_first_digit_dta(self):
        self.assertEqual(basechange.decimalToAlpha(24), 'aaaz')

    def test_start_second_digit_dta(self):
        self.assertEqual(basechange.decimalToAlpha(25), 'aaba')

    def test_random_dta(self):
        self.assertEqual(basechange.decimalToAlpha(678), 'abcd')

    def test_laur_dta(self):
        self.assertEqual(basechange.decimalToAlpha(172366), 'laur')

    def test_last_dta(self):
        self.assertEqual(basechange.decimalToAlpha(390624), 'zzzz')


if __name__ == '__main__':
    unittest.main()
