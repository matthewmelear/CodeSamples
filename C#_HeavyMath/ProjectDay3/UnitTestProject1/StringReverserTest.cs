using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StringReverser;

namespace UnitTestProject1
{

    
    [TestClass]
    public class StringReverserTest
    {
        StringReverser.StringReverser sr = new StringReverser.StringReverser();

        [TestMethod]
        public void TestReverseNullString()
        {
            Assert.AreEqual("", sr.ServiceMethod(""));
        }

        [TestMethod]
        public void TestReverseLargeString()
        {
            Assert.AreEqual("adoIFOSmCIaio", sr.ServiceMethod("oiaICmSOFIoda"));
        }
    }
}
