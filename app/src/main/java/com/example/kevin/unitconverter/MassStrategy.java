package com.example.kevin.unitconverter;

/**
 * Created by Kevin on 9/24/2015.
 */
public class MassStrategy implements UnitConversionStrategy {
    @Override
    public double Convert(String from, String to, double input) {
        if(from.equals("pounds")&&to.equals("kilgrams"))
        {
            double result = input*.0453592;
            return result;
        }
        if(from.equals("kilograms")&&to.equals("pounds"))
        {
            double result = input*2.20462;
            return result;
        }
        if(from.equals(to))
        {
            return input;
        }


        return 0;


    }
}
