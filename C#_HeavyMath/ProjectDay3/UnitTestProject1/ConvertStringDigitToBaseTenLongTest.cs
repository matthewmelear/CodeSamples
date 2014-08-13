using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace UnitTestProject1
{

    
    [TestClass]
    public class ConvertStringDigitToBaseTenLongTest
    {
        ConvertBase.ConvertStringDigitToBaseTenLong helper = new ConvertBase.ConvertStringDigitToBaseTenLong();

        [TestMethod]
        public void TestAEqualsTen()
        {
            Assert.AreEqual(10, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("A"));
        }

        [TestMethod]
        public void TestOneEqualsOne()
        {
            Assert.AreEqual(1, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("1"));
        }
        [TestMethod]
        public void TestZeroEqualsZero()
        {
            Assert.AreEqual(0, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("0"));
        }
        [TestMethod]
        public void TestTwoEqualsTwo()
        {
            Assert.AreEqual(2, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("2"));
        }
        [TestMethod]
        public void TestThreeEqualsThree()
        {
            Assert.AreEqual(3, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("3"));
        }
        [TestMethod]
        public void TestFourEqualsFour()
        {
            Assert.AreEqual(4, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("4"));
        }
        [TestMethod]
        public void TestFiveEqualsFive()
        {
            Assert.AreEqual(5, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("5"));
        }
        [TestMethod]
        public void TestSixEqualsSix()
        {
            Assert.AreEqual(6, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("6"));
        }
        [TestMethod]
        public void TestSevenEqualsSeven()
        {
            Assert.AreEqual(7, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("7"));
        }
        [TestMethod]
        public void TestEightEqualsEight()
        {
            Assert.AreEqual(8, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("8"));
        }
        [TestMethod]
        public void TestNineEqualsNine()
        {
            Assert.AreEqual(9, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("9"));
        }
        [TestMethod]
        public void TestBEqualsEleven()
        {
            Assert.AreEqual(11, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("B"));
        }
        [TestMethod]
        public void TestCEqualsTwelve()
        {
            Assert.AreEqual(12, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("C"));
        }
        [TestMethod]
        public void TestDEqualsThirteen()
        {
            Assert.AreEqual(13, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("D"));
        }
        [TestMethod]
        public void TestEEqualsFourteen()
        {
            Assert.AreEqual(14, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("E"));
        }
        [TestMethod]
        public void TestFEqualsFifteen()
        {
            Assert.AreEqual(15, ConvertBase.ConvertStringDigitToBaseTenLong.ServiceMethod("F"));
        }
    }
}
