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
        if(from.equals("Pints") && to.equals("Gallons"))
        {
            double result = input * 0.125;
            return result;
        }
        if(from.equals("Pints") && to.equals("Litres"))
        {
            double result = input * 0.473176;
            return result;
        }
        if(from.equals("Litres") && to.equals("Pints"))
        {
            double result = input * 2.11337612;
            return result;
        }
        if(from.equals("Gallons") && to.equals("Pints"))
        {
            double result = input * 8;
            return result;
        }




        if(from.equals("Quarts") && to.equals("Gallons"))
        {
            double result = input * 0.264172;
            return result;
        }
        if(from.equals("Quarts") && to.equals("Litres"))
        {
            double result = input * 3.78541;
            return result;
        }
        if(from.equals("Quarts") && to.equals("Pints"))
        {
            double result = input * 0.125;
            return result;
        }
        if(from.equals("Pints") && to.equals("Litres"))
        {
            double result = input * 0.473176;
            return result;
        }
        if(from.equals("Litres") && to.equals("Pints"))
        {
            double result = input * 2.11337612;
            return result;
        }
        if(from.equals("Gallons") && to.equals("Pints"))
        {
            double result = input * 8;
            return result;
        }
        if(from.equals(to))
        {
            return input;
        }
        return 0.0;
    }
}
