package com.example.kevin.unitconverter;

/**
 Author: Kevin Davison
 Version: 9/24/15
 Creates the conversions for volumetric measurements
 */
public class VolumeStrategy implements UnitConversionStrategy {
    @Override
    public double Convert(String from, String to, double input) {

        if(from.equals("Litres") && to.equals("Gallons"))
        {
            double result = input * 0.264172;
            return result;
        }
        if(from.equals("Gallons") && to.equals("Litres"))
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
