package com.example.kevin.unitconverter;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View.OnClickListener;
import android.widget.Toast;

/*
Author: Kevin Davison
Version: 9/24/15
This a simple unit converter that takes metric or imperial measurements and converts them to the other.
I use an interface and switches to find the correct "Strategy"
Similar to the grid plotter from CS 110.
 */


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
        unitArray.add(getResources().getString(R.string.area));
        unitArray.add(getResources().getString(R.string.distance));
        unitArray.add(getResources().getString(R.string.mass));
        unitArray.add(getResources().getString(R.string.temp));
        unitArray.add(getResources().getString(R.string.velocity));
        unitArray.add(getResources().getString(R.string.volume));


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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        if(view.getParent()==UnitType)
        {
            switch(position)
            {
                case 0:
                    setStrategy(new AreaStrategy());
                    break;
                case 1:
                    setStrategy(new DistanceStrategy());
                    break;
                case 2:
                    setStrategy(new MassStrategy());
                    break;
                case 3:
                    setStrategy(new TemperatureStrategy());
                    break;
                case 4:
                    setStrategy(new VelocityStrategy());
                    break;
                case 5:
                    setStrategy(new VolumeStrategy());
                    break;



            }
            fillFromToSpinners(position);

            UnitFrom.setSelection(0);
            UnitTo.setSelection(0);

            stringFrom = UnitFrom.getItemAtPosition(0).toString();
            stringTo = UnitTo.getItemAtPosition(0).toString();

            ResultValue.setText("");
        }
        else if(view.getParent() == UnitFrom)
        {
            stringFrom = UnitFrom.getSelectedItem().toString();
        }
        else if(view.getParent() == UnitTo)
        {
            stringTo = UnitTo.getSelectedItem().toString();
        }
    }
    public void onNothingSelected(AdapterView<?>parent)
    {

    }

    private void fillFromToSpinners(int position)
    {


        switch (position)
        {
            case 0:
                areaUnits();

                break;
            case 1:
                distanceUnits();

                break;
            case 2:
                massUnits();

                break;
            case 3:
                temperatureUnits();
                break;
            case 4:
                velocityUnits();
                break;
            case 5:
                volumeUnits();
                break;
        }
    }


    public void massUnits()
    {
        unitArrayFromTo.clear();
        for(String string: getResources().getStringArray(R.array.massUnits))
        {
            unitArrayFromTo.add(string);
        }
        unitArrayFromTo.notifyDataSetChanged();
    }
    public void areaUnits()
    {
        unitArrayFromTo.clear();
        for(String string: getResources().getStringArray(R.array.areaUnits))
        {
            unitArrayFromTo.add(string);
        }
        unitArrayFromTo.notifyDataSetChanged();
    }

    public void temperatureUnits()
    {
        unitArrayFromTo.clear();
        for(String string: getResources().getStringArray(R.array.tempUnits))
        {
            unitArrayFromTo.add(string);
        }
        unitArrayFromTo.notifyDataSetChanged();
    }
    public void distanceUnits()
    {
        unitArrayFromTo.clear();
        for(String string: getResources().getStringArray(R.array.distanceUnits))
        {
            unitArrayFromTo.add(string);
        }
        unitArrayFromTo.notifyDataSetChanged();
    }
    public void velocityUnits()
    {
        unitArrayFromTo.clear();
        for(String string: getResources().getStringArray(R.array.speedUnits))
        {
            unitArrayFromTo.add(string);
        }
        unitArrayFromTo.notifyDataSetChanged();
    }
    public void volumeUnits()
    {
        unitArrayFromTo.clear();
        for(String string: getResources().getStringArray(R.array.volumeUnits))
        {
            unitArrayFromTo.add(string);
        }
        unitArrayFromTo.notifyDataSetChanged();
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
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, "The position: " + stringFrom+ " " + stringTo + " " + input + " " + currentStrategy, duration);
                toast.show();
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
