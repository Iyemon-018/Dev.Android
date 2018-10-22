package com.example.iyemon018.kotlinlearning001

/**
 * 出力データを成型するためのインターフェース
 * Created by iyemon018 on 2018/10/22.
 */
interface Formatter {
    val data: String

    /**
     * 成型したデータを返します。
     * @return 成型したデータを返します。データは必ず出力可能な形式とする。
     */
    fun format(): String
}