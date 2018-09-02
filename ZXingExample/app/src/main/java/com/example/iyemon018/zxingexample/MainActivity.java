package com.example.iyemon018.zxingexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CompoundBarcodeView;

import java.util.List;

// 参考ページ : https://osa030.hatenablog.com/entry/2015/10/14/190350
// ZXing for GitHub : https://github.com/journeyapps/zxing-android-embedded
public class MainActivity extends AppCompatActivity {
    
    private CompoundBarcodeView _barcordView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        _barcordView = findViewById(R.id.barcodeView);
        _barcordView.decodeSingle(new BarcodeCallback() {
    
            @Override
            public void barcodeResult(BarcodeResult result) {
                TextView resultTextView = findViewById(R.id.resultTextView);
                resultTextView.setText(result.getText());
            }
    
            @Override
            public void possibleResultPoints(List<ResultPoint> resultPoints) {
        
            }
        });

    }
    
    @Override
    public void onResume() {
        super.onResume();
        _barcordView.resume();
    }
    
    @Override
    public void onPause() {
        super.onPause();
        _barcordView.pause();
    }
}