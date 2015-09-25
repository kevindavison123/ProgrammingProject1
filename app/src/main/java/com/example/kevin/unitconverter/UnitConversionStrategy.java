package com.example.kevin.unitconverter;

/**
 Author: Kevin Davison
 Version: 9/24/15
 Interface that dictates the correct conversion strategy 
 */
public interface UnitConversionStrategy
{
    public double Convert(String from, String to, double input);
}
