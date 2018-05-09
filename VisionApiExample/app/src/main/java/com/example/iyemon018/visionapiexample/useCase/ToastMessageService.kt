package com.example.iyemon018.visionapiexample.useCase

import android.content.Context
import android.widget.Toast

/**
 * Created by iyemon018 on 2018/05/09.
 */
class ToastMessageService(context: Context) : MessageService {

    private var context: Context = context

    override fun information(message: String) {
        show(message)
    }

    private fun show(message: String) {
        Toast.makeText(this.context, message, Toast.LENGTH_LONG).show()
    }
}