package com.example.kevin.unitconverter;

/**
 * Created by Kevin on 9/24/2015.
 */
public class TemperatureStrategy implements  UnitConversionStrategy
{
    @Override
    public double Convert(String from, String to, double input)
    {
        if(from.equals("Celsius") && to.equals("Fahrenheit"))
        {
            double result = ((input*9/5)+32);
            return result;
        }
        if(from.equals("Fahrenheit") && to.equals("Celsius"))
        {
            double result = ((input-32)*5/9);
            return result;
        }
        if(from.equals(to))
        {
            return input;
        }
        return input;
    }
}
