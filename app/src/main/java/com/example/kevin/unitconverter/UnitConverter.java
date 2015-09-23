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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UnitConverter extends Activity implements AdapterView.OnItemSelectedListener {

    ArrayAdapter<String> unitArray;
    ArrayAdapter<String> unitsAdapter;
    List<String> units = new ArrayList<String>();
    List<String> unitList = new ArrayList<String>();
    Map<String,List<String>> unitMap = new HashMap<String,List<String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);

        units.add(getResources().getString(R.string.temp));
        units.add(getResources().getString(R.string.mass));
        units.add(getResources().getString(R.string.velocity));
        units.add(getResources().getString(R.string.volume));
        units.add(getResources().getString(R.string.distance));
        for(String someUnit: getResources().getStringArray(R.array.distanceUnits))
        {
            unitList.add(someUnit);
        }
        for(String someUnit: getResources().getStringArray(R.array.volumeUnits))
        {
            unitList.add(someUnit);
        }
        for(String someUnit: getResources().getStringArray(R.array.tempUnits))
        {
            unitList.add(someUnit);
        }
        for(String someUnit: getResources().getStringArray(R.array.speedUnits))
        {
            unitList.add(someUnit);
        }
        for(String someUnit: getResources().getStringArray(R.array.massUnits))
        {
            unitList.add(someUnit);
        }

        String[] someUnitArray = unitList.toArray(new String[unitList.size()]);
        String[] someUnits = units.toArray(new String[units.size()]);

        Spinner spinnerUnitNames = (Spinner)findViewById(R.id.unit1);

        unitArray = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item);
        unitArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        unitsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnitNames.setAdapter(unitsAdapter);
        spinnerUnitNames.setOnItemSelectedListener(this);


        for(String string: someUnits)
        {
            unitsAdapter.add(string);
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
       Resources res = getResources();
        spinnerUnitNames.setOnItemSelectedListener(this);

       if(unitDisplayed.contains("temp"))
       {
          Toast toast = Toast.makeText(context,"temp was contained", duration);
           toast.show();
       }



    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        parent.getItemAtPosition(position);
    }
    public void onNothingSelected(AdapterView<?>parent)
    {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_unit_converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
