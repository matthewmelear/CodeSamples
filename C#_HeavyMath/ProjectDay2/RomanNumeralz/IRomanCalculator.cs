using System;

public interface IRomanCalculator
{
    String RunningTotal { get; }

    void Add(string operandValue);
    void Subtract(string operandValue);
    void Multiply(string operandValue);
    void Divide(string operandValue);

    decimal ConvertNumeralToDecimal(string numeralToConvert);
    string ConvertDecimalToNumeral(decimal decimalToConvert);
}
