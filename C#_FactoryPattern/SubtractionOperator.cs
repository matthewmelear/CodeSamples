using System;

public class SubtractionOperator : BinaryOperationBase
{
	public SubtractionOperator()
	{
	}

    public override void logAction()
    {
        Console.WriteLine("Subtraction has been chosen");
    }
    public override string compute(double firstNum, double secondNum)
    {
        return (firstNum - secondNum).ToString();
    }
}
