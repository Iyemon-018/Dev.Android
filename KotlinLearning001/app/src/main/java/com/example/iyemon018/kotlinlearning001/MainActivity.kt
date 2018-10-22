package com.example.iyemon018.kotlinlearning001

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {

    private val pathSeparator: String = File.separator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Download/KotlinLearning/item.csv ファイルを読み込む。
        // 実行前に設定からアプリに権限を付与すること。
        // 実行結果はRun を参照
        val downloadDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath
        val fileName = "${downloadDirectory}${pathSeparator}KotlinLearning${pathSeparator}item.csv"

        // also は対象のオブジェクトを初期化する際に使用する拡張関数のこと。
        // init の実行後に呼び出される。
        // 参考ページ : https://qiita.com/ngsw_taro/items/d29e3080d9fc8a38691e#also
        val content = FileLoader(File(fileName).also {
            // このタイミングでファイルの存在チェックをすることで、FileLoader のinit 時点でファイルは確実に存在することになる。
            if (!it.exists()) {
                throw IllegalArgumentException("$fileName にファイルがありません。")
            }
        }).load()
            ?: throw IllegalArgumentException("ファイルの中身がありません。")

        val formatter = TextFormatter(content)
        val writer = StdOutWriter()
        writer.write(formatter)
    }
}