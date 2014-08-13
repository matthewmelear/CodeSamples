using System;

public class AdditionOperator : BinaryOperationBase
{

	public AdditionOperator()
	{
	}

    public override void logAction()
    {
        Console.WriteLine("Addition has been chosen");
    }
    public override string compute(double firstNum, double secondNum)
    {
        return (firstNum + secondNum).ToString();
    }
}
