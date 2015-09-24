package com.example.kevin.unitconverter;

/**
 * Created by Kevin on 9/24/2015.
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
