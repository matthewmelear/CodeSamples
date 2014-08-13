using System;
using System.Text.RegularExpressions;

namespace InputValidator{
    public class InputValidator
    {
	    public InputValidator()
	    {
	    }

        public bool isValidBase(string input){
            if (input.Equals("10") || input.Equals("11") || input.Equals("12") || input.Equals("13") ||
                input.Equals("14") || input.Equals("15") || input.Equals("16"))    return true;       
   
            return false;
        }

        public bool isValidInputNumber(string input, string DesiredBase)
        {
            string REGEX_REQUIRED = "";
            if (DesiredBase.Equals("10")) REGEX_REQUIRED = "^[0-9]{1,45}$";
            if (DesiredBase.Equals("11")) REGEX_REQUIRED = "^[0-9aA]{1,45}$";
            if (DesiredBase.Equals("12")) REGEX_REQUIRED = "^[0-9a-bA-B]{1,45}$";
            if (DesiredBase.Equals("13")) REGEX_REQUIRED = "^[0-9a-cA-C]{1,45}$";
            if (DesiredBase.Equals("14")) REGEX_REQUIRED = "^[0-9a-dA-D]{1,45}$";
            if (DesiredBase.Equals("15")) REGEX_REQUIRED = "^[0-9a-eA-E]{1,45}$";
            if (DesiredBase.Equals("16")) REGEX_REQUIRED = "^[0-9a-fA-F]{1,45}$";

            Match match = Regex.Match(input, REGEX_REQUIRED);

            if (match.Success) return true;
            
            return false;
        }

        public bool isValidRestartInput(string input)
        {
            if (input.Equals("Y") || input.Equals("y") || input.Equals("N") || input.Equals("n")) return true;

            return false;
        }
    }
}
