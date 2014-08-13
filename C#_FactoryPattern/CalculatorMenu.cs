using System;
namespace System{
    public class CalculatorMenu
    {
        public CalculatorMenu()
        {
        }

        public void Welcomer()
        {
            Console.WriteLine("Welcome to the Calculator.");
        }

        public void OperationPrompt()
        {
            Console.WriteLine("And what operation would you like to use?");
            Console.WriteLine("1 for Addition (+)");
            Console.WriteLine("2 for Subtraction (-)");
            Console.WriteLine("3 for Multiplication (*)");
            Console.WriteLine("4 for Division (/)");
        }

        public void FirstNumberPrompt()
        {
            Console.WriteLine("To get started, enter a number.");
        }

        public void SecondNumberPrompt()
        {
            Console.WriteLine("And enter another number.");
        }

        public void SolutionDisplay(string solution)
        {
            Console.WriteLine("The solution is " + solution);
        }

        public void RestartOrExitPrompt()
        {
            Console.WriteLine("Would you like to compute some more?");
            Console.WriteLine("Press y for yes");
            Console.WriteLine("Press n for no");
        }

        public void NotANumberResponse()
        {
            Console.WriteLine("Oops, that wasn't a number.");
            Console.WriteLine("Try Again, please.");
        }

        public void NotAValidChoiceResponse()
        {
            Console.WriteLine("Oops, that wasn't a choice.");
            Console.WriteLine("Try Again, please.");
        }

        public void SayGoodbye()
        {
            Console.WriteLine("Goodbye!");
        }
    }
}