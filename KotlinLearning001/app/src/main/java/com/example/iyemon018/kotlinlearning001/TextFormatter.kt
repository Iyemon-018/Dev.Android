package com.example.iyemon018.kotlinlearning001

/**
 * Created by iyemon018 on 2018/10/22.
 */
class TextFormatter(override  val data: String) : Formatter {
    /**
     * 成型したデータを返します。
     * @return 成型したデータを返します。データは必ず出力可能な形式とする。
     */
    override fun format(): String {
        return data
    }
}