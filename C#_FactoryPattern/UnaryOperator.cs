using System;

public class UnaryOperator
{
	public UnaryOperator()
	{
	}

    public Double execute(string unaryOperator, double value){
        double result = 0;

        int unaryIndex = getIndexedValue(unaryOperator);

        switch (unaryIndex)
        {
            case 1:
                result = Math.Log(value, Math.E);
                break;
            case 2:
                result = Math.Log10(value);
                break;
            case 3:
                result = Math.Log(value, 2);
                break;
            case 4:
                string str = value.ToString();
                result = Convert.ToInt32(str, 2);
                break;
            case 5:
                result = Math.Exp(value);
                break;
            case 6:
                result = Math.Pow(value, 10);
                break;
            case 7:
                result = Math.Pow(value, 2);
                break;
            case 8:
                result = Math.Abs(value);
                break;
            case 9:
                //result = Math.Factorial(value);
                //break;
            case 10:
                result = Math.Asin(value);
                break;
            case 11:
                result = Math.Acos(value);
                break;
            case 12:
                result = Math.Atan(value);
                break;
            case 13:
                result = 1 / value;
                break;
            case 14:
                result = Math.Sin(value);
                break;
            case 15:
                result = Math.Cos(value);
                break;
            case 16:
                result = Math.Tan(value);
                break;
            case 17:
                result = Math.Pow(value, 2);
                break;
            case 18:
                result = Math.Pow(value, 0.5);
                break;
        }

        return result;
    }

    public int getIndexedValue(string unaryOperator)
    {
        if (unaryOperator.Equals("NaturalLog")) return 1;
        if (unaryOperator.Equals("Log")) return 2;
        if (unaryOperator.Equals("BinaryLog")) return 3;
        if (unaryOperator.Equals("Binary")) return 4;
        if (unaryOperator.Equals("EToTheX")) return 5;
        if (unaryOperator.Equals("TenToTheX")) return 6;
        if (unaryOperator.Equals("TwoToTheX")) return 7;
        if (unaryOperator.Equals("AbsoluteValue")) return 8;
        if (unaryOperator.Equals("Factorial")) return 9;
        if (unaryOperator.Equals("ArcSin")) return 10;
        if (unaryOperator.Equals("ArcCos")) return 11;
        if (unaryOperator.Equals("ArcTan")) return 12;
        if (unaryOperator.Equals("OneOverX")) return 13;
        if (unaryOperator.Equals("Sin")) return 14;
        if (unaryOperator.Equals("Cos")) return 15;
        if (unaryOperator.Equals("Tan")) return 16;
        if (unaryOperator.Equals("XSquared")) return 17;
        if (unaryOperator.Equals("SquareRoot")) return 18;
        return 0;
    }
}
