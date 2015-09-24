package com.example.kevin.unitconverter;

/**
 * Created by Kevin on 9/24/2015.
 */
public class VolumeStrategy implements UnitConversionStrategy {
    @Override
    public double Convert(String from, String to, double input) {

        if(from.equals("litre") && to.equals("gallon"))
        {
            double result = input * 0.264172;
            return result;
        }
        if(from.equals("gallon") && to.equals("litre"))
        {
            double result = input * 3.78541;
            return result;
        }
        if(from.equals(to))
        {
            return input;
        }
        return 0.0;
    }
}
