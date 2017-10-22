package com.example.butterknifesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private RadioButton exampleRadioButton;
    private Button exampleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exampleRadioButton = (RadioButton) findViewById(R.id.exampleRadioButton);
        exampleButton = (Button) findViewById(R.id.exampleButton);

    }
}
