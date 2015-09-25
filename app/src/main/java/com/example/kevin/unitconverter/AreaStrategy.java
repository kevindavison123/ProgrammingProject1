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
        if(from.equals("Square Miles")&&to.equals("Acres"))
        {
            double result = input*640;
            return result;
        }


        if(from.equals("Square Kilometers")&&to.equals("Square Miles"))
        {
            double result = input*0.386102;
            return result;
        }
        if(from.equals("Square Kilometers")&&to.equals("Acres"))
        {
            double result = input*247.105;
            return result;
        }


        if(from.equals("Acres")&&to.equals("Square Miles"))
        {
            double result = input*0.0015625;
            return result;
        }
        if(from.equals("Acres")&&to.equals("Square Kilometers"))
        {
            double result = input*0.00404686;
            return result;
        }
        if(from.equals(to))
        {
            return input;
        }

        return 0;
    }
}
