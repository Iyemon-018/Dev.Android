package com.example.iyemon018.lifecyclesample001

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var _stateTextView: TextView

    private lateinit var _editText: EditText

    private var _editTextTemp: String = ""

    /**
     * 初期化処理やビューの作成などを行う
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _stateTextView = findViewById(R.id.stateTextView)
        _editText = findViewById(R.id.editText)
        val customView = findViewById<MyCustomView>(R.id.indicator)
        val updateButton = findViewById<Button>(R.id.updateButton)
        updateButton.setOnClickListener {
            // 現在選択されているインジケーターの次を選択する。
            // 最後まで選択したら最初から選択しなおす。
            val selected = customView.selected + 1
            if (selected >= MyCustomView.INDICATOR_COUNT) {
                customView.setSelected(0, true)
            } else {
                customView.setSelected(selected, true)
            }
        }
    }

    /**
     * 不要なリソースの開放を行う。
     * onCreate と対になる
     * @see onCreate
     */
    override fun onDestroy() {
        super.onDestroy()
    }

    /**
     * 通信やセンサの処理の開始を行う。
     */
    override fun onStart() {
        super.onStart()
    }

    /**
     * 通信やセンサの処理を停止する。
     * onStart と対になる。
     * @see onStart
     */
    override fun onStop() {
        super.onStop()
    }

    /**
     * 通常は何もしない。アプリを再開・表示する際に呼ばれる。
     */
    override fun onRestart() {
        super.onRestart()
    }

    /**
     * 必要穴にメーションの実行など、画面の更新処理を開始する。
     */
    override fun onResume() {
        super.onResume()
    }

    /**
     * アニメーションなどの画面の更新処理の停止、一時停止時に不要なリソースの解放
     * 必要なデータの永続化をおこなう。
     * onResume と対になる。
     * @see onResume
     */
    override fun onPause() {
        super.onPause()
    }

    /**
     * Activity の状態を保存するために呼ばれる。
     * おもに画面の回転やスリープ時に呼び出される。
     */
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        _editTextTemp = this._editText.text.toString()

        // 引数のBundle 型オブジェクトは保存したいデータを保存する領域を示す。
        // putXXX でプリミティブな型と文字列、もしくはそのリストを保存することができる。
        // そのほかの型の場合は、Parcelable 型を実装したクラスであれば同じく保存可能。
        outState!!.putString("EDIT_TEXT", _editTextTemp)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        // 引数savedInstanceState にはonSaveInstanceState で保存したデータを取り出すことができる。
        _editTextTemp = savedInstanceState!!.getString("EDIT_TEXT")
        _editText.setText(_editTextTemp)
    }
}