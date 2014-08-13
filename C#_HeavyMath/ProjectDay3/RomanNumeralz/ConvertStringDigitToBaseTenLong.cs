using System;

namespace ConvertBase
{
    public class ConvertStringDigitToBaseTenLong
    {
        public ConvertStringDigitToBaseTenLong()
        {
        }

        public static long ServiceMethod(string input)
        {
            long result = 0;
            switch (input)
            {
                case "0":
                    result = 0;
                    break;
                case "1":
                    result = 1;
                    break;
                case "2":
                    result = 2;
                    break;
                case "3":
                    result = 3;
                    break;
                case "4":
                    result = 4;
                    break;
                case "5":
                    result = 5;
                    break;
                case "6":
                    result = 6;
                    break;
                case "7":
                    result = 7;
                    break;
                case "8":
                    result = 8;
                    break;
                case "9":
                    result = 9;
                    break;
                case "A":
                    result = 10;
                    break;
                case "B":
                    result = 11;
                    break;
                case "C":
                    result = 12;
                    break;
                case "D":
                    result = 13;
                    break;
                case "E":
                    result = 14;
                    break;
                case "F":
                    result = 15;
                    break;
            }
            return result;
        }
    }
}
