using System;

public class DivisionOperator : BinaryOperationBase
{
	public DivisionOperator()
	{
	}

    public override void logAction()
    {
        Console.WriteLine("Division has been chosen");
    }
    public override string compute(double firstNum, double secondNum)
    {
        double result = 0;
        if (secondNum != 0)
        {
            result = firstNum / secondNum;
            return result.ToString();
        } else if (firstNum > 0)
        {
            result = double.PositiveInfinity;
            return result.ToString();
        } else if (firstNum < 0)
        {
            result = double.NegativeInfinity;
            return result.ToString();
        }
        return "undefined";
    }
}
