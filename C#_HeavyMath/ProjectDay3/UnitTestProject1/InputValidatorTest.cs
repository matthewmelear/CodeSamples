using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StringReverser;

namespace UnitTestProject1
{

    
    [TestClass]
    public class InputValidatorTest
    {
        InputValidator.InputValidator iv = new InputValidator.InputValidator();

        [TestMethod]
        public void IsValidBasePositive()
        {
            Assert.IsTrue(iv.isValidBase("14"));
        }

        [TestMethod]
        public void IsValidBaseNegative()
        {
            Assert.IsFalse(iv.isValidBase("14.5"));
        }

        [TestMethod]
        public void IsValidInputNumberPositiveBaseTen()
        {
            Assert.IsTrue(iv.isValidInputNumber("142357892", "10"));
        }

        [TestMethod]
        public void IsValidInputNumberPositiveBaseEleven()
        {
            Assert.IsTrue(iv.isValidInputNumber("142AAA892", "11"));
        }


        [TestMethod]
        public void IsValidInputNumberPositiveBaseTwelve()
        {
            Assert.IsTrue(iv.isValidInputNumber("142BAA892", "12"));
        }

        [TestMethod]
        public void IsValidInputNumberPositiveBaseThirteen()
        {
            Assert.IsTrue(iv.isValidInputNumber("1c2BCA892", "13"));
        }

        [TestMethod]
        public void IsValidInputNumberPositiveBaseFourteen()
        {
            Assert.IsTrue(iv.isValidInputNumber("142BCA8dd2", "14"));
        }

        [TestMethod]
        public void IsValidInputNumberPositiveBaseFifteen()
        {
            Assert.IsTrue(iv.isValidInputNumber("ee42BCA8dd2", "15"));
        }

        [TestMethod]
        public void IsValidInputNumberPositiveBaseSixteen()
        {
            Assert.IsTrue(iv.isValidInputNumber("ee42BFA8fd2", "16"));
        }

        [TestMethod]
        public void IsValidInputNumberNegativeBaseTen()
        {
            Assert.IsFalse(iv.isValidInputNumber("ee42BFA8fd2", "10"));
        }

        [TestMethod]
        public void IsValidInputNumberNegativeBaseEleven()
        {
            Assert.IsFalse(iv.isValidInputNumber("ee42BFA8fd2", "11"));
        }


        [TestMethod]
        public void IsValidInputNumberNegativeBaseTwelve()
        {
            Assert.IsFalse(iv.isValidInputNumber("ee42BFA8fd2", "12"));
        }

        [TestMethod]
        public void IsValidInputNumberNegativeBaseThirteen()
        {
            Assert.IsFalse(iv.isValidInputNumber("ee42BFA8fd2", "13"));
        }

        [TestMethod]
        public void IsValidInputNumberNegativeBaseFourteen()
        {
            Assert.IsFalse(iv.isValidInputNumber("ee42BFA8fd2", "14"));
        }

        [TestMethod]
        public void IsValidInputNumberNegativeBaseFifteen()
        {
            Assert.IsFalse(iv.isValidInputNumber("ee42BFA8fd2", "15"));
        }

        [TestMethod]
        public void IsValidInputNumberNegativeBaseSixteen()
        {
            Assert.IsFalse(iv.isValidInputNumber("ee42B--8fd2", "16"));
        }
        
        [TestMethod]
        public void IsValidRestartInputY()
        {
            Assert.IsTrue(iv.isValidRestartInput("Y"));
        }

        [TestMethod]
        public void IsValidRestartInput()
        {
            Assert.IsTrue(iv.isValidRestartInput("Y"));
        }

        [TestMethod]
        public void IsValidRestartInputy()
        {
            Assert.IsTrue(iv.isValidRestartInput("y"));
        }

        [TestMethod]
        public void IsValidRestartInputN()
        {
            Assert.IsTrue(iv.isValidRestartInput("N"));
        }

        [TestMethod]
        public void IsValidRestartInputn()
        {
            Assert.IsTrue(iv.isValidRestartInput("n"));
        }

        [TestMethod]
        public void IsInvalidRestartInput()
        {
            Assert.IsFalse(iv.isValidRestartInput("g"));
        }
    }
}
