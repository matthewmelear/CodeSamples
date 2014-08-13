using System;
using System.Text;

namespace MenuDisplay
{
    public class MenuDisplay
    {
	    public MenuDisplay()
	    {
	    }

        public void Welcomer()
        {
            Console.WriteLine("Welcome to the palindrome magic maker");
        }

        public void BasePrompt(){
            Console.WriteLine("Please enter a base between 10 and 16 inclusive");
        }

        public void InvalidBasePrompt(){
            Console.WriteLine("Invalid Input.\nPlease enter a base between 10 and 16 inclusive");
        }

        public void NumberPrompt(string numberSystemAsString){
            Console.WriteLine("Please enter a starting number in this base.");
            StringBuilder sb = new StringBuilder();
            int numberSystem = int.Parse(numberSystemAsString);
            sb.Append("You may use 0 - 9");
            if (numberSystem > 10)
            {
                sb.Append(", A");
            }
            if (numberSystem > 11)
            {
                sb.Append(", B");
            }
            if (numberSystem > 12)
            {
                sb.Append(", C");
            }
            if (numberSystem > 13)
            {
                sb.Append(", D");
            }
            if (numberSystem > 14)
            {
                sb.Append(", E");
            }
            if (numberSystem > 15)
            {
                sb.Append(", F");
            }
            sb.Append(".");
            Console.WriteLine(sb.ToString());
        }

        public void InvalidNumberPrompt()
        {
            Console.WriteLine("Oops, Try Again");
        }

        public void ThinkingPrompt()
        {
            Console.WriteLine("Thinking......");
        }

        public void SolutionPrompt(string solution)
        {
            Console.WriteLine("The Answer is:");
            Console.WriteLine(solution);
        }

        public void NoSolutionPrompt(string leaveOffPoint)
        {
            Console.WriteLine("There was no answer");
            Console.WriteLine("But I left off at: " + leaveOffPoint);
        }

        public void RestartPrompt()
        {
            Console.WriteLine("Would you like to play again?");
            Console.WriteLine("Press y for yes, and n for no");
        }

        public void InvalidRestartPrompt()
        {
            Console.WriteLine("Oops, invalid input. Play again?");
            Console.WriteLine("Press y for yes, and n for no");
        }
    }
}
