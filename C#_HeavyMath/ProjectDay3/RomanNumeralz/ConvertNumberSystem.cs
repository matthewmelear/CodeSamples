using System;
using System.Collections.Generic;
using System.Text;

namespace ConvertBase
{
    public class ConvertNumberSystem
    {

        public long ConvertToBaseTenFromStart(string numberToConvert, string numberSystem)
        {
            long result = 0;
            int numberSystemAsInt = int.Parse(numberSystem);

            List<long> ListOfDigits = new List<long>();

            for (int i = 0; i < numberToConvert.Length; i++)
            {
                ListOfDigits.Add(ConvertStringDigitToBaseTenLong.ServiceMethod(numberToConvert.Substring(i, 1)));
            }

            for (int i = 0; i < ListOfDigits.Count; i++)
            {
                result += ListOfDigits[i];
                if (ListOfDigits.Count > i + 1)
                {
                    result *= numberSystemAsInt;
                }
            }
            return result;
        }




        
        public string ConvertFromBaseTenToStart(long numberToConvert, string numberSystem)
        {
            int NumberOfDigitsNeeded = 0;
            int NumberSystemAsInt = int.Parse(numberSystem);
            long numberCopy = numberToConvert;
            ConvertIntArrayToBaseAnythingDigitArray helper = new ConvertIntArrayToBaseAnythingDigitArray();


            while (numberCopy >= 1) {
                NumberOfDigitsNeeded++;
                numberCopy /= NumberSystemAsInt;
            }

            int[] digitsBeforeConversion = new int[NumberOfDigitsNeeded];
            numberCopy = numberToConvert;

            for (int i = 0; i < NumberOfDigitsNeeded; i++){
                while (numberCopy >= Math.Pow(NumberSystemAsInt, NumberOfDigitsNeeded - i - 1)){
                    digitsBeforeConversion[i]++;
                    numberCopy -= (long) Math.Pow(NumberSystemAsInt, NumberOfDigitsNeeded - i - 1);
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < NumberOfDigitsNeeded; i++)
            {
                sb.Append(helper.ServiceMethod(digitsBeforeConversion[i]));
            }

                return sb.ToString();
        }
    }
}
