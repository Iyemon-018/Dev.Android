package com.example.iyemon018.listviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    
    @BindView(R.id.listView)
    ListView listView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        
        DailyAdapter dailyAdapter = new DailyAdapter(MainActivity.this);
    
        LinkedList<DataForHour> dataList = new LinkedList<>();
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
    
        Random random = new Random();
        
        for (int hour=0; hour<24; hour++) {
            dataList.add(new DataForHour(today.getTime(), (float)random.nextInt(100)));
            today.add(Calendar.HOUR, 1);
        }
        
        dailyAdapter.addDataAll(dataList);
        listView.setAdapter(dailyAdapter);
    }
}
