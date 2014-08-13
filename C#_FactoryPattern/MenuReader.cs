using System;

public class MenuReader
{
    MenuReader menuReader = null;

	public MenuReader()
	{
	}

    public double readDouble(string input)
    {
        return double.Parse(input);
    }

    public int readOperationInput(string input)
    {
        if (input.Equals("+")) return 1;
        if (input.Equals("-")) return 2;
        if (input.Equals("*")) return 3;
        if (input.Equals("/")) return 4;
        return int.Parse(input);
    }


    internal bool isRestartDesired(string restartChoice)
    {
        return (restartChoice.Equals("y") || restartChoice.Equals("Y"));
    }
}
