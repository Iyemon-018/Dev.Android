package com.example.iyemon018.handyterminalkeyboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import java.util.List;

/**
 * Created by iyemon018 on 2018/03/12.
 */
public final class CustomKeyboardView extends KeyboardView {
    
    private final Context context;
    
    private Keyboard keyboard;
    
    
    public CustomKeyboardView(Context context, AttributeSet attrs) {
        
        super(context, attrs);
        this.context = context;
    }
    
    @Override
    public void onDraw(Canvas canvas) {
        
        super.onDraw(canvas);
        
        //
        // 以下のページを参考にした。
        // https://stackoverflow.com/questions/17714172/how-to-change-key-background-of-any-key-in-android-soft-keyboard
        // https://stackoverflow.com/questions/3185237/android-keyboard-keys-background
        //
        this.keyboard = this.getKeyboard();
        List<Keyboard.Key> keys = this.keyboard == null ? null : this.keyboard.getKeys();
        
        if (keys != null) {
            for (Keyboard.Key key : keys) {
                // ここで見た目を変更したいキーのcodes を指定する。
                if (key.codes[0] == 30) {
                    // こんな漢字で変更すればKey の外観が変わる。
                    Drawable drawable = ContextCompat.getDrawable(this.context, R.drawable.keyboardview_enter_background);
                    int[] drawableState = key.getCurrentDrawableState();
                    drawable.setState(drawableState);
                    
                    drawable.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                    drawable.draw(canvas);
    
                    // ここからラベルの設定になる。
                    Paint paint = new Paint();
                    paint.setTextAlign(Paint.Align.CENTER);
                    paint.setTextSize(48);
                    paint.setAntiAlias(true);
                    paint.setColor(Color.WHITE);
                    
                    canvas.drawText(key.label.toString(), key.x + key.width / 2, key.y + key.height / 2, paint);
                    
                }
            }
        }
    }
}
