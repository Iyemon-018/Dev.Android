package com.example.preferenceexampleapp;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * このアプリのエントリポイントです。
 * Created by i_m_a on 2017/10/22.
 */

public final class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 設定にて保存した情報は、以下の方法で取得することができる。
        // Context 内に設定を保存したActivity が含まれる場合は、
        // 自動的にその設定Activity が保存した設定ファイルを読み込むらしい。
        SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(this);

        // 値の取得は以下の方法で実行できる。
        // String 以外にもBoolean とかある。
        // 取得できない場合の戻り値を第二引数に設定する。
        String text = p.getString("example_text", "");
    }
}
