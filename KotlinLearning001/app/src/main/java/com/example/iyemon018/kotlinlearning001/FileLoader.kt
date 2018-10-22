package com.example.iyemon018.kotlinlearning001

import java.io.File

/**
 * Created by iyemon018 on 2018/10/22.
 */
class FileLoader(private val file:File): Loader {
    init {
        require(file.exists())
    }

    override fun load(): String? = file.readText()
}