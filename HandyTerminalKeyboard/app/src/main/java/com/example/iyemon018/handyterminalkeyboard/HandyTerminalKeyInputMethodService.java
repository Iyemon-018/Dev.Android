package com.example.iyemon018.handyterminalkeyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.View;
import android.view.inputmethod.InputConnection;

/**
 * Created by iyemon018 on 2018/02/22.
 */
public final class HandyTerminalKeyInputMethodService extends InputMethodService
        implements KeyboardView.OnKeyboardActionListener {
    
    /**
     * Create and return the view hierarchy used for the input area (such as
     * a soft keyboard).  This will be called once, when the input area is
     * first displayed.  You can return null to have no input area; the default
     * implementation returns null.
     * <p>
     * <p>To control when the input view is displayed, implement
     * {@link #onEvaluateInputViewShown()}.
     * To change the input view after the first one is created by this
     * function, use {@link #setInputView(View)}.
     */
    @Override
    public View onCreateInputView() {
        KeyboardView keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.handy_keyboard_layout, null);
        Keyboard keyboard = new Keyboard(this, R.xml.handy_terminal_pad);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        keyboardView.setPreviewEnabled(false);
        return keyboardView;
    }
    
    /**
     * Called when the user presses a key. This is sent before the {@link #onKey} is called.
     * For keys that repeat, this is only called once.
     *
     * @param primaryCode the unicode of the key being pressed. If the touch is not on a valid
     *                    key, the value will be zero.
     */
    @Override
    public void onPress(int primaryCode) {
    
    }
    
    /**
     * Called when the user releases a key. This is sent after the {@link #onKey} is called.
     * For keys that repeat, this is only called once.
     *
     * @param primaryCode the code of the key that was released
     */
    @Override
    public void onRelease(int primaryCode) {
    
    }
    
    /**
     * Send a key press to the listener.
     *
     * @param primaryCode this is the key that was pressed
     * @param keyCodes    the codes for all the possible alternative keys
     *                    with the primary code being the first. If the primary key code is
     *                    a single character such as an alphabet or number or symbol, the alternatives
     *                    will include other characters that may be on the same key or adjacent keys.
     *                    These codes are useful to correct for accidental presses of a key adjacent to
     */
    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
    
        InputConnection inputConnection = getCurrentInputConnection();
        if (inputConnection != null) {
//            switch (primaryCode) {
//            }
        }
    }
    
    /**
     * Sends a sequence of characters to the listener.
     *
     * @param text the sequence of characters to be displayed.
     */
    @Override
    public void onText(CharSequence text) {
    
    }
    
    /**
     * Called when the user quickly moves the finger from right to left.
     */
    @Override
    public void swipeLeft() {
    
    }
    
    /**
     * Called when the user quickly moves the finger from left to right.
     */
    @Override
    public void swipeRight() {
    
    }
    
    /**
     * Called when the user quickly moves the finger from up to down.
     */
    @Override
    public void swipeDown() {
    
    }
    
    /**
     * Called when the user quickly moves the finger from down to up.
     */
    @Override
    public void swipeUp() {
    
    }
}
