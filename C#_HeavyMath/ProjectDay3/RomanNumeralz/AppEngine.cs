using System;
using MenuDisplay;
using InputValidator;

namespace AppEngine
{
    public class AppEngine
    {
        public AppEngine()
        {
        }

        private bool firstTimeThrough = true;

        public void Execute()
        {
            MenuDisplay.MenuDisplay md = new MenuDisplay.MenuDisplay();
            bool canContinue = false;
            InputValidator.InputValidator iv = new InputValidator.InputValidator();
            string InputNumber = "";
            string DesiredBase = "";
            string ReversedInputNumber = "";
            StringReverser.StringReverser sr = new StringReverser.StringReverser();
            int TimesThroughIteration = 0;
            bool foundSolution = false;
            long InputNumberAsLong = 0;
            long ReversedInputNumberAsLong = 0;
            ConvertBase.ConvertNumberSystem cns = new ConvertBase.ConvertNumberSystem();

            if (firstTimeThrough)
            {
                md.Welcomer();
            }

            md.BasePrompt();
            DesiredBase = Console.ReadLine();

            if (iv.isValidBase(DesiredBase))
            {
                canContinue = true;
            }

            while (!canContinue)
            {
                md.InvalidBasePrompt();
                DesiredBase = Console.ReadLine();
                if (iv.isValidBase(DesiredBase))
                {
                    canContinue = true;
                }
            }

            md.NumberPrompt(DesiredBase);
            InputNumber = Console.ReadLine();
            canContinue = false;

            if (iv.isValidInputNumber(InputNumber, DesiredBase))
            {
                canContinue = true;
            }

            while (!canContinue)
            {
                md.InvalidNumberPrompt();
                InputNumber = Console.ReadLine();
                if (iv.isValidInputNumber(InputNumber, DesiredBase))
                {
                    canContinue = true;
                }
            }

            ReversedInputNumber = sr.ServiceMethod(InputNumber);
            canContinue = false;

            while (!canContinue)
            {
                if (InputNumber.Equals(ReversedInputNumber))
                {
                    canContinue = true;
                    foundSolution = true;
                }
                else if (TimesThroughIteration < 10)
                {
                    InputNumberAsLong = cns.ConvertToBaseTenFromStart(InputNumber, DesiredBase);
                    ReversedInputNumberAsLong = cns.ConvertToBaseTenFromStart(ReversedInputNumber, DesiredBase);
                    InputNumberAsLong += ReversedInputNumberAsLong;
                    TimesThroughIteration++;
                    InputNumber = cns.ConvertFromBaseTenToStart(InputNumberAsLong, DesiredBase);
                    ReversedInputNumber = sr.ServiceMethod(InputNumber);
                }
                else
                {
                    canContinue = true;
                }
            }

            if (foundSolution)
            {
                md.SolutionPrompt(InputNumber);
            }
            else
            {
                md.NoSolutionPrompt(InputNumber);
            }
        }

        public bool IsRestartDesired()
        {
            MenuDisplay.MenuDisplay md = new MenuDisplay.MenuDisplay();
            string RestartPromptResponse = "";
            bool canContinue = false;
            InputValidator.InputValidator iv = new InputValidator.InputValidator();

            md.RestartPrompt();
            RestartPromptResponse = Console.ReadLine();

            if (iv.isValidRestartInput(RestartPromptResponse))
            {
                canContinue = true;
            }

            while (!canContinue)
            {
                md.InvalidRestartPrompt();
                RestartPromptResponse = Console.ReadLine();
                if (iv.isValidRestartInput(RestartPromptResponse))
                {
                    canContinue = true;
                }
            }

            if (RestartPromptResponse.Equals("Y") || RestartPromptResponse.Equals("y")) return true;
            
            return false;
        }
    }
}
