using System;

public class MultiplicationOperator : BinaryOperationBase
{
	public MultiplicationOperator()
	{
	}

    public override void logAction()
    {
        Console.WriteLine("Multiplication has been chosen");
    }
    public override string compute(double firstNum, double secondNum)
    {
        return (firstNum * secondNum).ToString();
    }
}
