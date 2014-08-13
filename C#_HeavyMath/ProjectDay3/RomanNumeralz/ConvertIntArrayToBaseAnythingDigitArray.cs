using System;

public class ConvertIntArrayToBaseAnythingDigitArray
{
    public ConvertIntArrayToBaseAnythingDigitArray()
	{
	}

    public string ServiceMethod(int BaseTen)
    {
        string result = "";
        switch (BaseTen)
        {
            case 0:
                result = "0";
                break;
            case 1:
                result = "1";
                break;
            case 2:
                result = "2";
                break;
            case 3:
                result = "3";
                break;
            case 4:
                result = "4";
                break;
            case 5:
                result = "5";
                break;
            case 6:
                result = "6";
                break;
            case 7:
                result = "7";
                break;
            case 8:
                result = "8";
                break;
            case 9:
                result = "9";
                break;
            case 10:
                result = "A";
                break;
            case 11:
                result = "B";
                break;
            case 12:
                result = "C";
                break;
            case 13:
                result = "D";
                break;
            case 14:
                result = "E";
                break;
            case 15:
                result = "F";
                break;
        }
        return result;
    }
}
