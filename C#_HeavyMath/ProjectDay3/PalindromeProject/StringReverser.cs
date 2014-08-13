using System;
using System.Collections.Generic;
using System.Text;

namespace StringReverser{
    public class StringReverser
    {
	    public StringReverser()
	    {
	    }

        public string ServiceMethod(string input)
        {
            List<string> ReversedDigits = new List<string>();

            for (int i = input.Length-1; i > -1; i--)
            {
                ReversedDigits.Add(input.Substring(i, 1));
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < ReversedDigits.Count; i++)
            {
                sb.Append(ReversedDigits[i]);
            }
                return sb.ToString();
        }
    }
}
