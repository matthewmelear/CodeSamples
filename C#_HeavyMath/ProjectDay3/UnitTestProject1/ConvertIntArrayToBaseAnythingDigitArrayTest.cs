using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;


namespace UnitTestProject1
{

    
    [TestClass]
    public class ConvertIntArrayToBaseAnythingDigitArrayTest
    {
        ConvertIntArrayToBaseAnythingDigitArray helper = new ConvertIntArrayToBaseAnythingDigitArray();

        [TestMethod]
        public void TestAEqualsTen()
        {
            Assert.AreEqual("A", helper.ServiceMethod(10));
        }

        [TestMethod]
        public void TestOneEqualsOne()
        {
            Assert.AreEqual("1", helper.ServiceMethod(1));
        }
        [TestMethod]
        public void TestZeroEqualsZero()
        {
            Assert.AreEqual("0", helper.ServiceMethod(0));
        }
        [TestMethod]
        public void TestTwoEqualsTwo()
        {
            Assert.AreEqual("2", helper.ServiceMethod(2));
        }
        [TestMethod]
        public void TestThreeEqualsThree()
        {
            Assert.AreEqual("3", helper.ServiceMethod(3));
        }
        [TestMethod]
        public void TestFourEqualsFour()
        {
            Assert.AreEqual("4", helper.ServiceMethod(4));
        }
        [TestMethod]
        public void TestFiveEqualsFive()
        {
            Assert.AreEqual("5", helper.ServiceMethod(5));
        }
        [TestMethod]
        public void TestSixEqualsSix()
        {
            Assert.AreEqual("6", helper.ServiceMethod(6));
        }
        [TestMethod]
        public void TestSevenEqualsSeven()
        {
            Assert.AreEqual("7", helper.ServiceMethod(7));
        }
        [TestMethod]
        public void TestEightEqualsEight()
        {
            Assert.AreEqual("8", helper.ServiceMethod(8));
        }
        [TestMethod]
        public void TestNineEqualsNine()
        {
            Assert.AreEqual("9", helper.ServiceMethod(9));
        }
        [TestMethod]
        public void TestBEqualsEleven()
        {
            Assert.AreEqual("B", helper.ServiceMethod(11));
        }
        [TestMethod]
        public void TestCEqualsTwelve()
        {
            Assert.AreEqual("C", helper.ServiceMethod(12));
        }
        [TestMethod]
        public void TestDEqualsThirteen()
        {
            Assert.AreEqual("D", helper.ServiceMethod(13));
        }
        [TestMethod]
        public void TestEEqualsFourteen()
        {
            Assert.AreEqual("E", helper.ServiceMethod(14));
        }
        [TestMethod]
        public void TestFEqualsFifteen()
        {
            Assert.AreEqual("F", helper.ServiceMethod(15));
        }

        //[TestMethod]
        //public void TestReverseLargeString()
        //{
        //    Assert.AreEqual("adoIFOSmCIaio", sr.ServiceMethod("oiaICmSOFIoda"));
        //}
    }
}
