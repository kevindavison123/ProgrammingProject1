package com.example.kevin.unitconverter;

/**
 Author: Kevin Davison
 Version: 9/24/15
 Creates the conversions for distance measurements
 */
public class DistanceStrategy implements UnitConversionStrategy {
    @Override
    public double Convert(String from, String to, double input) {
        if(from.equals("Miles")&&to.equals("Kilometers"))
        {
            double result = input*1.60934;
            return result;
        }
        if(from.equals("Kilometers")&&to.equals("Miles"))
        {
            double result = input*0.621371;
            return result;
        }
        if(from.equals("Kilometers")&&to.equals("Yards"))
        {
            double result = input*1093.61;
            return result;
        }
        if(from.equals("Miles")&&to.equals("Yards"))
        {
            double result = input*1760;
            return result;
        }
        if(from.equals("Yards")&&to.equals("Miles"))
        {
            double result = input*0.000568182;
            return result;
        }
        if(from.equals("Yards")&&to.equals("Kilometers"))
        {
            double result = input*0.0009144;
            return result;
        }
        if(from.equals("Kilometers")&&to.equals("Feet"))
        {
            double result = input*0.621371;
            return result;
        }
        if(from.equals("Miles")&&to.equals("Feet"))
        {
            double result = input*5280;
            return result;
        }
        if(from.equals("Yards")&&to.equals("Feet"))
        {
            double result = input*3;
            return result;
        }
        if(from.equals("Feet")&&to.equals("Miles"))
        {
            double result = input*0.000189394;
            return result;
        }
        if(from.equals("Feet")&&to.equals("Kilometers"))
        {
            double result = input*0.0003048;
            return result;
        }
        if(from.equals("Feet")&&to.equals("Yards"))
        {
            double result = input*0.333333;
            return result;
        }
        if(from.equals(to))
        {
            return input;
        }
        return 0;
    }
}
