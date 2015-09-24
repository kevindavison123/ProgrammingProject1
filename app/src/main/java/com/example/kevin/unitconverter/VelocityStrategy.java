package com.example.kevin.unitconverter;

/**
 * Created by Kevin on 9/24/2015.
 */
public class VelocityStrategy implements UnitConversionStrategy {
    @Override
    public double Convert(String from, String to, double input) {

        if(from.equals("miles/hr")&&to.equals("km/hr"))
        {
            double result =input*1.60934;
            return result;
        }
        if(from.equals("km/hr")&&to.equals("miles/hr"))
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