using System;

public class CalculatorMenuValidator
{
	public CalculatorMenuValidator()
	{
	}

    public bool IsValidDouble(string o)
    {
        bool result = false;
        double n;
        try
        {
            n = double.Parse(o);
            result = true;
        }
        catch (Exception e)
        { 
        }
        return result;
    }

    public bool IsValidInt(string o)
    {
        bool result = false;
        int n;
        try
        {
            n = int.Parse(o);
            result = true;
        }
        catch (Exception e)
        {
        }
        return result;
    }

    public bool IsValidOperatorChoice(string o)
    {
        if (IsValidInt(o) && (int.Parse(o) > 0) && (int.Parse(o) < 5)) return true;
        if (o.Equals("+") || o.Equals("*") || o.Equals("/") || o.Equals("-")) return true;
        return false;
    }



    internal bool isValidRestartChoice(string restartChoice)
    {
        if (restartChoice.Equals("y") || restartChoice.Equals("Y") || restartChoice.Equals("n") || restartChoice.Equals("N")) return true;
        return false;
    }
}