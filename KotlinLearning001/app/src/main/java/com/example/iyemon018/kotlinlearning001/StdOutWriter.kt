package com.example.iyemon018.kotlinlearning001

/**
 * Created by iyemon018 on 2018/10/22.
 */

/**
 * 出力する機能を提供するインターフェースです。
 */
interface Writer {
    /**
     * 指定した書式の情報を出力します。
     * @param formatter 書式化された情報を成型する
     */
    fun write(formatter: Formatter)
}

/**
 * 標準出力用の出力クラスです。
 */
class StdOutWriter : Writer {
    /**
     * 指定した書式の情報を出力します。
     * @param formatter 書式化された情報を成型する
     */
    override fun write(formatter: Formatter) {
        println(formatter.format())
    }
}