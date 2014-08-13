using System;
using System.Collections.Generic;
using System.Text;
using Validator;

namespace RomanCalculator
{
    public class RomanCalculator : IRomanCalculator
    {
	    public RomanCalculator()
	    {
	    }

        public string _RunningTotal = "N";
        public string RunningTotal
        {
            get
            {
                return _RunningTotal;
            }
            private set
            {
                _RunningTotal = value;
            }
        }

        public void Add(string operandValue)
        {
            decimal decimalValueRunningTotal = ConvertNumeralToDecimal(RunningTotal);
            decimal decimalValueToOperateOn = 0;
            if (Validator.NumeralValidator.isValidNumeral(operandValue))
            {
                decimalValueToOperateOn = ConvertNumeralToDecimal(operandValue);
            }
            decimalValueRunningTotal += decimalValueToOperateOn;
            RunningTotal = ConvertDecimalToNumeral(decimalValueRunningTotal);       

        }
        public void Subtract(string operandValue)
        {
            decimal decimalValueRunningTotal = ConvertNumeralToDecimal(RunningTotal);
            decimal decimalValueToOperateOn = 0;
            if (Validator.NumeralValidator.isValidNumeral(operandValue))
            {
                decimalValueToOperateOn = ConvertNumeralToDecimal(operandValue);
            }
            decimal temporaryDecimalValueRunningTotal = decimalValueRunningTotal - decimalValueToOperateOn;

            if (temporaryDecimalValueRunningTotal > 0)
            {
            decimalValueRunningTotal -= decimalValueToOperateOn;
            }
            else
            {
                throw new ArgumentException();
            }
            RunningTotal = ConvertDecimalToNumeral(decimalValueRunningTotal);  
        }
        public void Multiply(string operandValue)
        {
            decimal decimalValueRunningTotal = ConvertNumeralToDecimal(RunningTotal);
            decimal decimalValueToOperateOn = 1;
            if (Validator.NumeralValidator.isValidNumeral(operandValue))
            {
                decimalValueToOperateOn = ConvertNumeralToDecimal(operandValue);
            }
            decimalValueRunningTotal *= decimalValueToOperateOn;
            RunningTotal = ConvertDecimalToNumeral(decimalValueRunningTotal);  
        }
        public void Divide(string operandValue)
        {
            decimal decimalValueRunningTotal = ConvertNumeralToDecimal(RunningTotal);
            decimal decimalValueToOperateOn = 1;
            if (Validator.NumeralValidator.isValidNumeral(operandValue))
            {
                decimalValueToOperateOn = ConvertNumeralToDecimal(operandValue);
            }
            decimal decimalValuePlaceHolder = decimalValueRunningTotal / decimalValueToOperateOn;
            decimalValueRunningTotal = Decimal.Floor(decimalValuePlaceHolder);
            RunningTotal = ConvertDecimalToNumeral(decimalValueRunningTotal);  
        }

        public decimal ConvertNumeralToDecimal(string numeralToConvert)
        {
            decimal result = 0;
            List<decimal> decimalsToBeSummed = new List<decimal>();

            for (int i = 0; i < numeralToConvert.Length; i++)
            {
                if (numeralToConvert.Substring(i, 1).Equals("M"))
                {
                    result += 1000;
                }
                if (numeralToConvert.Substring(i, 1).Equals("D"))
                {
                    result += 500;
                }
                if (numeralToConvert.Substring(i, 1).Equals("C"))
                {
                    if ((numeralToConvert.Length > i+1) && (numeralToConvert.Substring(i+1, 1).Equals("D") || numeralToConvert.Substring(i+1, 1).Equals("M"))){
                        result -= 100;
                    } else {
                        result += 100;
                    }
                }
                if (numeralToConvert.Substring(i, 1).Equals("L"))
                {
                    result += 50;
                }
                if (numeralToConvert.Substring(i, 1).Equals("X"))
                {
                    if ((numeralToConvert.Length > i+1) && (numeralToConvert.Substring(i+1, 1).Equals("L") || numeralToConvert.Substring(i+1, 1).Equals("C"))){
                        result -= 10;
                    } else {
                        result += 10;
                    }
                }
                if (numeralToConvert.Substring(i, 1).Equals("V"))
                {
                    result += 5;
                }
                if (numeralToConvert.Substring(i, 1).Equals("I"))
                {
                    if ((numeralToConvert.Length > i+1) && (numeralToConvert.Substring(i+1, 1).Equals("V") || numeralToConvert.Substring(i+1, 1).Equals("X"))){
                        result -= 1;
                    } else {
                        result += 1;
                    }
                }
            }
            return result;
        }

        public string ConvertDecimalToNumeral(decimal decimalToConvert)
        {
            StringBuilder sbResult = new StringBuilder("");
            List<decimal> primedDecimalsForConversion = new List<decimal>();
            List<string> numeralsReceived = new List<string>();

            while (decimalToConvert > 0)
            {
                while (decimalToConvert > 999)
                {
                    sbResult.Append("M");
                    decimalToConvert -= 1000;
                }
                if (decimalToConvert > 900)
                {
                    sbResult.Append("CM");
                    decimalToConvert -= 900;
                }
                if (decimalToConvert > 499)
                {
                    sbResult.Append("D");
                    decimalToConvert -= 500;
                }
                if (decimalToConvert > 400)
                {
                    sbResult.Append("CD");
                    decimalToConvert -= 400;
                }
                while (decimalToConvert > 99)
                {
                    sbResult.Append("C");
                    decimalToConvert -= 100;
                }
                if (decimalToConvert > 90)
                {
                    sbResult.Append("XC");
                    decimalToConvert -= 90;
                }
                if (decimalToConvert > 49)
                {
                    sbResult.Append("L");
                    decimalToConvert -= 50;
                }
                if (decimalToConvert > 40)
                {
                    sbResult.Append("XL");
                    decimalToConvert -= 40;
                }
                while (decimalToConvert > 9)
                {
                    sbResult.Append("X");
                    decimalToConvert -= 10;
                }
                if (decimalToConvert == 9)
                {
                    sbResult.Append("IX");
                    decimalToConvert -= 9;
                }
                if (decimalToConvert > 4)
                {
                    sbResult.Append("V");
                    decimalToConvert -= 5;
                }
                if (decimalToConvert == 4)
                {
                    sbResult.Append("IV");
                    decimalToConvert -= 4;
                }
                while (decimalToConvert > 0)
                {
                    sbResult.Append("I");
                    decimalToConvert -= 1;
                }

            }
            string result = "";
            result = sbResult.ToString();
            if (result.Equals(""))
            {
                result = "N";
            }
                return result;
        }
    }
}