package com.example.iyemon018.fragmentsample001

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {
    /**
     * 何ら可能操作が実行された際に呼ばれます。
     */
    override fun onFragmentInteraction() {
        Toast.makeText(applicationContext, "ボタンが押されました。", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
