package com.example.iyemon018.materialcalendarsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    private MaterialCalendarView calendarView;

    private Spinner showOtherDatesSpinner;

    private final static LinkedHashMap<Integer, Integer> showOtherDatesMap
            = new LinkedHashMap<Integer, Integer>()
    {
        {
            put(0, MaterialCalendarView.SHOW_DEFAULTS);
            put(1, MaterialCalendarView.SHOW_OTHER_MONTHS);
            put(2, MaterialCalendarView.SHOW_OUT_OF_RANGE);
            put(3, MaterialCalendarView.SHOW_DECORATED_DISABLED);
            put(4, MaterialCalendarView.SHOW_ALL);
            put(5, MaterialCalendarView.SHOW_NONE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.calendarView = findViewById(R.id.calendarView);
        this.showOtherDatesSpinner = findViewById(R.id.showOtherDatesSpinner);
        this.showOtherDatesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calendarView.setShowOtherDates(showOtherDatesMap.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.show_other_dates_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.showOtherDatesSpinner.setAdapter(adapter);
    }
}
