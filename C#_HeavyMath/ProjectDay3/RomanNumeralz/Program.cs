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
            AppEngine.AppEngine ae = new AppEngine.AppEngine();
            do
            {
                ae.Execute();
            } while (ae.IsRestartDesired());
        }
    }
}
