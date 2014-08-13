using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RomanNumeralz
{
    class Program
    {
        static void Main(string[] args)
        {
            RomanCalculator.RomanCalculator rc = new RomanCalculator.RomanCalculator();
            rc.Add("XXV");
        }
    }
}
