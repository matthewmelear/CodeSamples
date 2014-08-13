using System;

namespace Validator
{
    public class NumeralValidator
    {
        public NumeralValidator()
        {
        }

        public static bool isValidNumeral(string operand)
        {
            bool result = true;
            if (!hasValidSymbols(operand) || !hasTheRightNumberOfEachSymbol(operand) || !symbolsComeInProperOrder(operand))
            {
                result = false;
            }
            if (result != true)
            {
                throw new ArgumentException();
            }
            return result;
        }

        public static bool hasValidSymbols(string operand)
        {
            bool result = true;
            for (int i = 0; i < operand.Length; i++)
            {
                if (!operand.Substring(i, 1).Equals("M") && !operand.Substring(i, 1).Equals("D") &&
                    !operand.Substring(i, 1).Equals("C") && !operand.Substring(i, 1).Equals("L") &&
                    !operand.Substring(i, 1).Equals("X") && !operand.Substring(i, 1).Equals("V") &&
                    !operand.Substring(i, 1).Equals("I"))
                {
                    result = false;
                }
            }
            return result;
        }

        public static bool hasTheRightNumberOfEachSymbol(string operand)
        {
            bool result = true;
            int[] ofEachType = { 0, 0, 0, 0, 0, 0, 0 };

            for (int i = 0; i < operand.Length; i++)
            {
                if (operand.Substring(i, 1).Equals("M"))
                {
                    ofEachType[0]++;
                }
                if (operand.Substring(i, 1).Equals("D"))
                {
                    ofEachType[1]++;
                }
                if (operand.Substring(i, 1).Equals("C"))
                {
                    ofEachType[2]++;
                }
                if (operand.Substring(i, 1).Equals("L"))
                {
                    ofEachType[3]++;
                }
                if (operand.Substring(i, 1).Equals("X"))
                {
                    ofEachType[4]++;
                }
                if (operand.Substring(i, 1).Equals("V"))
                {
                    ofEachType[5]++;
                }
                if (operand.Substring(i, 1).Equals("I"))
                {
                    ofEachType[6]++;
                }
            }

            if (ofEachType[0] > 4 || ofEachType[1] > 1 || ofEachType[2] > 4 || 
                ofEachType[3] > 1 || ofEachType[4] > 4 || ofEachType[5] > 1 || ofEachType[6] > 3)
            {
                result = false;
            }

            return result;
        }

        public static bool symbolsComeInProperOrder(string operand)
        {
            bool result = true;
            for (int i = 0; i < operand.Length; i++)
            {
                if (operand.Substring(i, 1).Equals("I"))
                {
                    for (int j = i; j < operand.Length; j++)
                    {
                        if (operand.Substring(j, 1).Equals("L") || operand.Substring(j, 1).Equals("C") || operand.Substring(j, 1).Equals("D") || operand.Substring(j, 1).Equals("M"))
                        {
                            result = false;
                        }
                    }
                }
                if (operand.Substring(i, 1).Equals("V"))
                {
                    for (int j = i; j < operand.Length; j++)
                    {
                        if (operand.Substring(j, 1).Equals("L") || operand.Substring(j, 1).Equals("X") || operand.Substring(j, 1).Equals("C") || operand.Substring(j, 1).Equals("D") || operand.Substring(j, 1).Equals("M"))
                        {
                            result = false;
                        }
                    }
                }
                if (operand.Substring(i, 1).Equals("X"))
                {
                    for (int j = i; j < operand.Length; j++)
                    {
                        if (operand.Substring(j, 1).Equals("D") || operand.Substring(j, 1).Equals("M"))
                        {
                            result = false;
                        }
                    }
                }
                if (operand.Substring(i, 1).Equals("L"))
                {
                    for (int j = i; j < operand.Length; j++)
                    {
                        if (operand.Substring(j, 1).Equals("D") || operand.Substring(j, 1).Equals("M") || operand.Substring(j, 1).Equals("C"))
                        {
                            result = false;
                        }
                    }
                }
                if (operand.Substring(i, 1).Equals("D"))
                {
                    for (int j = i; j < operand.Length; j++)
                    {
                        if (operand.Substring(j, 1).Equals("M"))
                        {
                            result = false;
                        }
                    }
                }
            }
            return result;
        }
    }
}
