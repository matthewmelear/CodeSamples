using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using RomanCalculator;

namespace UnitTestProject1
{

    [TestClass]
    public class RomanCalculatorTests
    {
        RomanCalculator.RomanCalculator rc = new RomanCalculator.RomanCalculator();

        [TestMethod]
        public void TestSuccessConvertNumeralToDecimal()
        {
            decimal result = rc.ConvertNumeralToDecimal("XXI");
            Assert.AreEqual(result, 21);
        }

        [TestMethod]
        public void TestSuccessConvertHugeNumeralToDecimal()
        {
            decimal result = rc.ConvertNumeralToDecimal("MMCDXLIX");
            Assert.AreEqual(result, 2449);
        }

        [TestMethod]
        public void TestSuccessConvertHugeNumeralToDecimalAgain()
        {
            decimal result = rc.ConvertNumeralToDecimal("MCMLXXXIV");
            Assert.AreEqual(result, 1984);
        }

        [TestMethod]
        public void TestSuccessConvertDecimalToNumeral()
        {
            string result = rc.ConvertDecimalToNumeral(21);
            Assert.AreEqual(result, "XXI");
        }
        [TestMethod]
        public void TestSuccessConvertHugeDecimalToNumeral()
        {
            string result = rc.ConvertDecimalToNumeral(1987);
            Assert.AreEqual(result, "MCMLXXXVII");
        }
        [TestMethod]
        public void TestSuccessConvertHugeDecimalToNumeralAgain()
        {
            string result = rc.ConvertDecimalToNumeral(3929);
            Assert.AreEqual(result, "MMMCMXXIX");
        }

        [TestMethod]
        public void TestSuccessAddWithRunningTotalZero()
        {
            rc.Add("XXIV");
            Assert.AreEqual(rc.RunningTotal, "XXIV");
        }
        [TestMethod]
        public void TestSuccessAddToRunningTotalNotZero()
        {
            rc.Add("XVII");
            rc.Add("XV");
            Assert.AreEqual(rc.RunningTotal, "XXXII");

        }
        [TestMethod]
        public void TestSuccessMultiplyToRunningTotalZero()
        {
            rc.Multiply("XVII");
            Assert.AreEqual(rc.RunningTotal, "N");

        }

        [TestMethod]
        public void TestSuccessMultiplyToRunningTotalNotZero()
        {
            rc.Add("IV");
            rc.Multiply("XVII");
            Assert.AreEqual(rc.RunningTotal, "LXVIII");

        }

        [TestMethod]
        public void TestSuccessMultiplyToRunningTotalTwice()
        {
            rc.Add("IV");
            rc.Multiply("XVII");
            rc.Multiply("X");
            Assert.AreEqual(rc.RunningTotal, "DCLXXX");

        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "Cannot subtract before running total becomes nonZero")]
        public void TestSuccessSubtractToRunningTotalZero()
        {
            rc.Subtract("VII");
        }

        [TestMethod]
        public void TestSuccessSubtractToRunningTotalNotZero()
        {
            rc.Add("XXV");
            rc.Subtract("XVII");
            Assert.AreEqual(rc.RunningTotal, "VIII");

        }

        [TestMethod]
        public void TestSuccessSubtractToRunningTotalTwice()
        {
            rc.Add("CDXI");
            rc.Subtract("LXXXVII");
            rc.Subtract("XII");
            Assert.AreEqual(rc.RunningTotal, "CCCXII");

        }

        [TestMethod]
        public void TestSuccessDivideRunningTotalTwiceToZero()
        {
            rc.Add("CDXI");
            rc.Divide("CDXI");
            rc.Divide("V");
            Assert.AreEqual(rc.RunningTotal, "N");

        }

        [TestMethod]
        public void TestSuccessDivideRunning()
        {
            rc.Add("CCC");
            rc.Divide("III");
            Assert.AreEqual(rc.RunningTotal, "C");

        }

        [TestMethod]
        public void TestSuccessDivideRoundingDown()
        {
            rc.Add("CCC");
            rc.Divide("VII");
            Assert.AreEqual(rc.RunningTotal, "XLII");

        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "Cannot even put in a zero")]
        public void TestZeroNotAllowed()
        {
            Validator.NumeralValidator.isValidNumeral("N");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "Cannot have a negative solution to subtraction")]
        public void TestThrownExceptionNegativeSubtractionResult()
        {
            rc.Add("CDXI");
            rc.Subtract("MV");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "G is not a roman numeral")]
        public void TestThrownExceptionUsingWrongSymbols()
        {
            Validator.NumeralValidator.isValidNumeral("G");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "C cannot come after I")]
        public void TestThrownExceptionCAfterI()
        {
            Validator.NumeralValidator.isValidNumeral("IC");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "M cannot come after I")]
        public void TestThrownExceptionMAfterI()
        {
            Validator.NumeralValidator.isValidNumeral("IM");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "M cannot come after X")]
        public void TestThrownExceptionMAfterX()
        {
            Validator.NumeralValidator.isValidNumeral("XM");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "L cannot come after V")]
        public void TestThrownExceptionLCannotComeAfterV()
        {
            Validator.NumeralValidator.isValidNumeral("VL");
        }

        [TestMethod]
        public void TestPositiveIsValidNumeral()
        {
            Assert.IsTrue(Validator.NumeralValidator.isValidNumeral("LVII"));
        }

        [TestMethod]
        public void TestPositiveIsValidNumeralAgain()
        {
            Assert.IsTrue(Validator.NumeralValidator.isValidNumeral("MMDCLXXVIII"));
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "Too Many M's")]
        public void TestThrownExceptionTooManyMs()
        {
            Validator.NumeralValidator.isValidNumeral("MMMMM");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "Too Many D's")]
        public void TestThrownExceptionTooManyDs()
        {
            Validator.NumeralValidator.isValidNumeral("DD");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "Too Many C's")]
        public void TestThrownExceptionTooManyCs()
        {
            Validator.NumeralValidator.isValidNumeral("CCCCC");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "Too Many L's")]
        public void TestThrownExceptionTooManyLs()
        {
            Validator.NumeralValidator.isValidNumeral("LL");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "Too Many X's")]
        public void TestThrownExceptionTooManyXs()
        {
            Validator.NumeralValidator.isValidNumeral("XXXXX");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "Too Many V's")]
        public void TestThrownExceptionTooManyVs()
        {
            Validator.NumeralValidator.isValidNumeral("VV");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "Too Many I's")]
        public void TestThrownExceptionTooManyIs()
        {
            Validator.NumeralValidator.isValidNumeral("IIIII");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "Can't Use lower case numerals")]
        public void TestThrownExceptionLowerCase()
        {
            Validator.NumeralValidator.isValidNumeral("iv");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException),
            "Can't Use lower case numerals again")]
        public void TestThrownExceptionLowerCaseAgain()
        {
            Validator.NumeralValidator.isValidNumeral("x");
        }
    }
}
