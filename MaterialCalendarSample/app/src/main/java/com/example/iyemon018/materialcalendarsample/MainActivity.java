package com.example.iyemon018.materialcalendarsample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.iyemon018.materialcalendarsample.decorator.DayOfWeekViewDecorator;
import com.example.iyemon018.materialcalendarsample.decorator.TodayViewDecorator;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.format.DateFormatTitleFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Locale;

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

        // タイトル部の書式を設定する。
        // MaterialCalenderView#setTitleFormatter(TitleFormatter format) を使用する。
        // 引数には書式化するためのフォーマット インターフェースを引き渡す。
        // TitleFormatter はSimpleDateFormat によって設定可能なDateFormatTitleFormatter とMonthArrayTitleFormatter が用意されている。
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月", Locale.getDefault());
        this.calendarView.setTitleFormatter(new DateFormatTitleFormatter(dateFormat));

        // 現在日付の装飾を設定する。
        this.calendarView.addDecorator(new TodayViewDecorator());

        // 日曜日と土曜日の装飾を設定する。
        this.calendarView.addDecorators(new DayOfWeekViewDecorator(Calendar.SUNDAY, Color.RED)
                                    , new DayOfWeekViewDecorator(Calendar.SATURDAY, Color.BLUE));
    }
}
