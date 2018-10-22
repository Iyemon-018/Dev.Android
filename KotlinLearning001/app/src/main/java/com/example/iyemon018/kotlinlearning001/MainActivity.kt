package com.example.iyemon018.kotlinlearning001

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {

    private val pathSeparator: String = File.separator

    private val lineSeparator: String = System.getProperty("line.separator")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Download/KotlinLearning/item.csv ファイルを読み込む。
        // 実行前に設定からアプリに権限を付与すること。
        // 実行結果はRun を参照
        val downloadDirectory =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath
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

        // item.csv の値段を税込み価格で出力する。
        val pricesOfFile = formatter.format().split(lineSeparator)                          // １行単位で取り出し
            .drop(1)                                     // 1行目はヘッダーなので読み飛ばす。 これはC# の.Skip(1) とおなじ。
            .map { x -> x.split(",")[2].trimEnd() }  // 各行の3 列目[値段列]の数値を取り出す。改行が含まれているのでtrimEnd する。(多分Windows OS 上で作ったファイルなので改行コードがAndroid 用ではない)
            .filter { x -> !x.isNullOrEmpty() }             // 空白は除外しておく。この拡張関数はデフォルトで定義されていて便利。
            .map { x -> x.toInt() }                         // 文字列から数値へのキャスト
            .map { x -> x * 1.08 }                          // 税込み価格へ変換する。
        println(pricesOfFile)

        //
        // fold はC# でいうところの.Aggregate と同じ。
        // 第一引数は初期値、第二引数は実行されるアクション
        // 以下の結果は fold = 6 となる。
        //
        val list = listOf(1, 2, 3)
        val fold = list.fold(0) { s1, s2 -> s1 + s2 }
        println(fold)

        //
        // map はC# でいうところの.Select と同じ。
        //
        val prices = listOf(100, 230, 980, 10923)
        val pricesTaxInclude = prices.map { x -> x * 1.08 }
        println(pricesTaxInclude)

        //
        // スコープ関数 let
        // おもに単一オブジェクトのmap のような使い方をする。
        // 用途としてはnullable オブジェクトの射影ぽく使う。
        // つまり object?.let { (変換処理) }
        // こんな感じ。
        // これだと、object が null の場合は、左辺が null になる。
        // object が not null の場合は、左辺が 変換処理の実行結果になる。
        //
        val upper = "test"?.let { it.toUpperCase() }
        println(upper)
    }
}