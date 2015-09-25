package com.example.kevin.unitconverter;

/**
 Author: Kevin Davison
 Version: 9/24/15
 Creates the conversions for velocity measurements
 */
public class VelocityStrategy implements UnitConversionStrategy {
    @Override
    public double Convert(String from, String to, double input) {

        if(from.equals("Miles/hour")&&to.equals("Kilometers/hour"))
        {
            double result =input*1.60934;
            return result;
        }
        if(from.equals("Kilometers/hour")&&to.equals("Miles/hour"))
        {
            double result = input*0.621371;
            return result;
        }
        if(from.equals(to))
        {
            return input;
        }
        return 0;
    }
}
