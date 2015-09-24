package com.example.kevin.unitconverter;

/**
 * Created by Kevin on 9/24/2015.
 */
public class AreaStrategy implements UnitConversionStrategy
{
    @Override
    public double Convert(String from, String to, double input) {
        if(from.equals("square miles")&&to.equals("square kilometers"))
        {
           double result = input*2.58999;
            return result;
        }
        if(from.equals("square kilometers")&&to.equals("square miles"))
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
