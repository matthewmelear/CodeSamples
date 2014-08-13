using System;

public class Calculator
{
	public Calculator()
	{
	}

    double firstNum;
    double secondNum;
    BinaryOperationBase bob;
    int operationChosen;
    string solution;
    CalculatorMenuValidator cmv = new CalculatorMenuValidator();
    CalculatorMenu cm = new CalculatorMenu();
    MenuReader mr = new MenuReader();
    bool isFirstTimeThrough = true;


    public void execute()
    {
        if (isFirstTimeThrough)
        {
            isFirstTimeThrough = false;
            cm.Welcomer();
        }

        bool canContinue = false;
        cm.FirstNumberPrompt();
        while (!canContinue)
        {
            
            String inputOne = Console.ReadLine();
            if (cmv.IsValidDouble(inputOne))
            {
                canContinue = true;
                firstNum = mr.readDouble(inputOne);
            }
            if (!canContinue)
            {
                cm.NotANumberResponse();
            }
        }

        cm.OperationPrompt();
        canContinue = false;

        while (!canContinue)
        {
            String inputTwo = Console.ReadLine();
            if (cmv.IsValidOperatorChoice(inputTwo))
            {
                canContinue = true;
                operationChosen = mr.readOperationInput(inputTwo);
            }
            if (!canContinue)
            {
                cm.NotAValidChoiceResponse();
            }
        }

        cm.SecondNumberPrompt();
        canContinue = false;


        while (!canContinue)
        {

            String inputThree = Console.ReadLine();
            if (cmv.IsValidDouble(inputThree))
            {
                canContinue = true;
                secondNum = mr.readDouble(inputThree);
            }
            if (!canContinue)
            {
                cm.NotANumberResponse();
            }
        }

        solution = calculate(firstNum, operationChosen, secondNum);
        cm.SolutionDisplay(solution);

    }

    public bool isRestartDesired()
    {
        cm.RestartOrExitPrompt();
        String restartChoice = Console.ReadLine();
        bool canContinue = false;
        while (!cmv.isValidRestartChoice(restartChoice))
        {
            cm.RestartOrExitPrompt();
            restartChoice = Console.ReadLine();
        }
        if (!mr.isRestartDesired(restartChoice))
        {
            cm.SayGoodbye();
        }
        return mr.isRestartDesired(restartChoice);
    }

    public string calculate(double firstNum, int operationChosen, double secondNum)
    {
        string result = "";
        switch (operationChosen)
        {
            case 1:  
                bob = new AdditionOperator();
                result = bob.compute(firstNum, secondNum);
                break;
            case 2:
                bob = new SubtractionOperator();
                result = bob.compute(firstNum, secondNum);
                break;
            case 3:
                bob = new MultiplicationOperator();
                result = bob.compute(firstNum, secondNum);
                break;
            case 4:
                bob = new DivisionOperator();
                result = bob.compute(firstNum, secondNum);
                break;
        }
        return result;
    }
}
