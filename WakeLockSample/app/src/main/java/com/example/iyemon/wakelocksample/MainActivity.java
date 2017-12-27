package com.example.iyemon.wakelocksample;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements WakeLockListener {

    private WakeLockBroadcastReceiver wakeLockBroadcastReceiver;
    private TextView loggingTextView;

    private final String NewLine =  System.getProperty("line.separator");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.loggingTextView = (TextView)findViewById(R.id.loggingTextView);

        wakeLockBroadcastReceiver = new WakeLockBroadcastReceiver(this);
        registerReceiver(wakeLockBroadcastReceiver, new IntentFilter(Intent.ACTION_SCREEN_ON));
        registerReceiver(wakeLockBroadcastReceiver, new IntentFilter(Intent.ACTION_SCREEN_OFF));
    }

    @Override
    public void onScreenOn() {
        String text = loggingTextView.getText().toString();
        loggingTextView.setText(text + NewLine + getNow() + " Screen On.");
    }

    @Override
    public void onScreenOff() {
        String text = loggingTextView.getText().toString();
        loggingTextView.setText(text + NewLine + getNow() + " Screen Off.");
    }

    private String getNow(){
        return DateFormat.format("yyyy/MM/dd HH:mm:ss", Calendar.getInstance()).toString();
    }
}
