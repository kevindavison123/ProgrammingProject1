package com.example.kevin.unitconverter;

/**
 Author: Kevin Davison
 Version: 9/24/15
 Creates the conversions for mass measurements
 */
public class MassStrategy implements UnitConversionStrategy {
    @Override
    public double Convert(String from, String to, double input) {
        if(from.equals("Pounds")&&to.equals("Kilograms"))
        {
            double result = input*.0453592;
            return result;
        }
        if(from.equals("Kilograms")&&to.equals("Pounds"))
        {
            double result = input*2.20462;
            return result;
        }
        if(from.equals("Pounds")&&to.equals("Ounces"))
        {
            double result = input*16;
            return result;
        }
        if(from.equals("Kilograms")&&to.equals("Ounces"))
        {
            double result = input*35.274;
            return result;
        }
        if(from.equals("Ounces")&&to.equals("Kilograms"))
        {
            double result = input*0.0283495;
            return result;
        }
        if(from.equals("Ounces")&&to.equals("Pounds"))
        {
            double result = input*0.0625;
            return result;
        }
        if(from.equals("Pounds")&&to.equals("Tons"))
        {
            double result = input*0.0005;
            return result;
        }
        if(from.equals("Kilograms")&&to.equals("Tons"))
        {
            double result = input*907.1847400036112;
            return result;
        }
        if(from.equals("Tons")&&to.equals("Kilograms"))
        {
            double result = input*0.00110231131092;
            return result;
        }
        if(from.equals("Tons")&&to.equals("Pounds"))
        {
            double result = input*2000;
            return result;
        }
        if(from.equals("Tons")&&to.equals("Ounces"))
        {
            double result = input*32000;
            return result;
        }
        if(from.equals("Ounces")&&to.equals("Tons"))
        {
            double result = input*0.000003125;
            return result;
        }

        if(from.equals(to))
        {
            return input;
        }


        return 0;


    }
}
