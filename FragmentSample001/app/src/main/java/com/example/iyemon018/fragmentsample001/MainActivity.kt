package com.example.iyemon018.fragmentsample001

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {
    /**
     * 何ら可能操作が実行された際に呼ばれます。
     */
    override fun onFragmentInteraction() {
        Toast.makeText(applicationContext, "ボタンが押されました。", Toast.LENGTH_LONG).show()
    }

    private var _number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 追加ボタンのClickListener
        findViewById<Button>(R.id.add_button).setOnClickListener { v ->

            // トランザクションの作成
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction()
                // Fragment を作成する。
                .add(R.id.fragment_container, ContainerFragment.getInstance(_number))
                // バックスタックに追加
                .addToBackStack(null)
                .commit()
        }

        // 削除ボタンのClickListener
        findViewById<Button>(R.id.remove_button).setOnClickListener { v ->
            if (_number == 0) return@setOnClickListener

            // バックスタックから取り出せばスタック上のFragment を削除できる。
            val fragmentManager = supportFragmentManager
            fragmentManager.popBackStack()
        }

        // バックスタックにFragment が追加されたときのリスナーを登録する。
        val fragmentManager = supportFragmentManager
        fragmentManager.addOnBackStackChangedListener {
            // ここでは現在の番号を保持する。
            // 現在の番号はバックスタックのフラグメントのインデックスとしている。
            val fragments = fragmentManager.fragments.filter { x -> x != null }
            _number = fragments.size
        }

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                .add(R.id.fragment_container, ContainerFragment.getInstance(_number), "FRAGMENT_TAG")
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(KEY_NUMBER, _number)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        _number = savedInstanceState?.getInt(KEY_NUMBER)!!
    }

    companion object {
        private const val KEY_NUMBER: String = "KEY_NUMBER"
    }
}