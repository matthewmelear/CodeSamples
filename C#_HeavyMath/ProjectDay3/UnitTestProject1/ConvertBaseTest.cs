using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ConvertBase;



namespace UnitTestProject1
{

    [TestClass]
    public class ConvertBaseTest
    {
        ConvertBase.ConvertNumberSystem cns = new ConvertBase.ConvertNumberSystem();

        [TestMethod]
        public void TestConvertBaseElevenToBaseTen()
        {
            Assert.AreEqual(10, cns.ConvertToBaseTenFromStart("A", "11"));

        }

        [TestMethod]
        public void TestConvertBaseElevenToBaseTenAgain()
        {
            Assert.AreEqual(140, cns.ConvertToBaseTenFromStart("118", "11"));

        }

        [TestMethod]
        public void TestConvertBaseTenToBaseTen()
        {
            Assert.AreEqual(15, cns.ConvertToBaseTenFromStart("15", "10"));

        }

        [TestMethod]
        public void TestConvertBaseTenToBaseTenAgain()
        {
            Assert.AreEqual(4312789, cns.ConvertToBaseTenFromStart("4312789", "10"));

        }

        [TestMethod]
        public void TestConvertBaseTwelveToBaseTen()
        {
            Assert.AreEqual(54, cns.ConvertToBaseTenFromStart("46", "12"));

        }

        [TestMethod]
        public void TestConvertBaseTwelveToBaseAgain()
        {
            Assert.AreEqual(142, cns.ConvertToBaseTenFromStart("BA", "12"));

        }

        [TestMethod]
        public void TestConvertBaseThirteenToBaseTen()
        {
            Assert.AreEqual(649, cns.ConvertToBaseTenFromStart("3AC", "13"));

        }

        [TestMethod]
        public void TestConvertBaseFourteenToBaseTen()
        {
            Assert.AreEqual(782, cns.ConvertToBaseTenFromStart("3DC", "14"));

        }

        [TestMethod]
        public void TestConvertBaseFifteenToBaseTen()
        {
            Assert.AreEqual(839, cns.ConvertToBaseTenFromStart("3AE", "15"));

        }

        [TestMethod]
        public void TestConvertBaseSixteenToBaseTen()
        {
            Assert.AreEqual(1020, cns.ConvertToBaseTenFromStart("3FC", "16"));

        }

        [TestMethod]
        public void TestConvertBaseTenToBaseEleven()
        {
            Assert.AreEqual("A", cns.ConvertFromBaseTenToStart(10, "11"));

        }

        [TestMethod]
        public void TestConvertBaseTenToBaseElevenBigger()
        {
            Assert.AreEqual("109A", cns.ConvertFromBaseTenToStart(1440, "11"));

        }

        [TestMethod]
        public void TestConvertBaseTenToBaseTwelve()
        {
            Assert.AreEqual("BA1", cns.ConvertFromBaseTenToStart(1705, "12"));

        }

        [TestMethod]
        public void TestConvertBaseTenToBaseThirteen()
        {
            Assert.AreEqual("CCA", cns.ConvertFromBaseTenToStart(2194, "13"));

        }

        [TestMethod]
        public void TestConvertBaseTenToBaseFourteen()
        {
            Assert.AreEqual("D4D", cns.ConvertFromBaseTenToStart(2617, "14"));

        }

        [TestMethod]
        public void TestConvertBaseTenToBaseFifteen()
        {
            Assert.AreEqual("D4D", cns.ConvertFromBaseTenToStart(2998, "15"));

        }

        [TestMethod]
        public void TestConvertBaseTenToBaseSixteen()
        {
            Assert.AreEqual("D4D", cns.ConvertFromBaseTenToStart(3405, "16"));

        }

        [TestMethod]
        public void TestConvertBaseTenToBaseTenReversed()
        {
            Assert.AreEqual(15, cns.ConvertToBaseTenFromStart("15", "10"));

        }

        [TestMethod]
        public void TestConvertBaseTenToBaseTenReversedAgain()
        {
            Assert.AreEqual(4312789, cns.ConvertToBaseTenFromStart("4312789", "10"));

        }


    }
}
