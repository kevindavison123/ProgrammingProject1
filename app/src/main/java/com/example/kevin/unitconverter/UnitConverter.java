package com.example.kevin.unitconverter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View.OnClickListener;

import android.widget.Toast;
import android.widget.Button;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UnitConverter extends Activity implements OnClickListener, AdapterView.OnItemSelectedListener {

    private Spinner UnitType;
    private Spinner UnitFrom;
    private Spinner UnitTo;
    private EditText InputValue;
    private EditText ResultValue;
    private Button CreateResult;
    ArrayAdapter<String> unitArray;
    ArrayAdapter<String>unitArrayFromTo;
    private UnitConversionStrategy currentStrategy;
    private UnitConversionStrategy lastStrategy;
    private String stringFrom;
    private String stringTo;
    private static UnitConverter instance;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);
        UnitType = (Spinner) findViewById(R.id.type);
        UnitType.setOnItemSelectedListener(this);

        unitArray= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        unitArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        UnitType.setAdapter(unitArray);
        unitArray.add(getResources().getString(R.string.temp));
        unitArray.add(getResources().getString(R.string.distance));
        unitArray.add(getResources().getString(R.string.volume));
        unitArray.add(getResources().getString(R.string.mass));
        unitArray.add(getResources().getString(R.string.velocity));
        unitArray.add(getResources().getString(R.string.area));
        unitArray.setNotifyOnChange(true);

        UnitFrom = (Spinner)findViewById(R.id.unitFrom);
        UnitFrom.setOnItemSelectedListener(this);
        UnitTo = (Spinner)findViewById(R.id.unitTo);
        UnitTo.setOnItemSelectedListener(this);

        unitArrayFromTo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        unitArrayFromTo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        UnitFrom.setAdapter(unitArrayFromTo);
        UnitTo.setAdapter(unitArrayFromTo);

        unitArrayFromTo.setNotifyOnChange(true);

        ResultValue = (EditText) findViewById(R.id.result);
        ResultValue.setClickable(false);

        CreateResult = (Button)findViewById(R.id.convertButton);
        CreateResult.setOnClickListener(this);
        InputValue = (EditText)findViewById(R.id.value1);
        currentStrategy = new AreaStrategy();
        lastStrategy=currentStrategy;
        instance = this;
    }
    public static UnitConverter getInstance() {
        return instance;
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        if(view.getParent()==UnitType)
        {
            switch(position)
            {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;


            }
            fillFromToSpinner(position);
        }

    }

    private void fillFromToSpinner(int position) {
    }

    public void onNothingSelected(AdapterView<?>parent)
    {

    }
    public void areaUnits()
    {
        unitArrayFromTo.clear();
        for(String string: getResources().getStringArray(R.array.tempUnits))
        {
            unitArrayFromTo.add(string);
        }
    }

    public void temperatureUnits()
    {
        unitArrayFromTo.clear();
        for(String string: getResources().getStringArray(R.array.tempUnits))
        {
            unitArrayFromTo.add(string);
        }
    }
    public void distanceUnits()
    {
        unitArrayFromTo.clear();
        for(String string: getResources().getStringArray(R.array.distanceUnits))
        {
            unitArrayFromTo.add(string);
        }
    }
    public void velocityUnits()
    {
        unitArrayFromTo.clear();
        for(String string: getResources().getStringArray(R.array.speedUnits))
        {
            unitArrayFromTo.add(string);
        }
    }
    public void volumeUnits()
    {
        unitArrayFromTo.clear();
        for(String string: getResources().getStringArray(R.array.volumeUnits))
        {
            unitArrayFromTo.add(string);
        }
    }
    public void onClick(View view)
    {
        if(view == CreateResult)
        {
            if(!InputValue.getText().toString().equals(""))
            {
                double input = Double.parseDouble(InputValue.getText().toString());
                double result = currentStrategy.Convert(stringFrom,stringTo,input);
                ResultValue.setText(Double.toString(result));
            }
            else
            {
                ResultValue.setText("");
            }
        }
    }
    private void setStrategy(UnitConversionStrategy strat)
    {
        lastStrategy = currentStrategy;
        currentStrategy = strat;
        lastStrategy = null;
    }
}
