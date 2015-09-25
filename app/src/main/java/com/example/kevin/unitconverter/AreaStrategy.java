package com.example.kevin.unitconverter;

/**
 Author: Kevin Davison
 Version: 9/24/15
 Creates the conversions for area measurements
 */
public class AreaStrategy implements UnitConversionStrategy
{
    @Override
    public double Convert(String from, String to, double input) {
        if(from.equals("Square Miles")&&to.equals("Square Kilometers"))
        {
           double result = input*2.58999;
            return result;
        }
        if(from.equals("Square Kilometers")&&to.equals("Square Miles"))
        {
            double result = input*2.58999;
            return result;
        }
        if(from.equals(to))
        {
            return input;
        }

        return 0;
    }
}
