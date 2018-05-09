package com.example.iyemon018.visionapiexample.viewModel

import android.arch.lifecycle.ViewModel
import com.example.iyemon018.visionapiexample.useCase.MessageService

/**
 * Created by iyemon018 on 2018/05/09.
 */

class MainActivityViewModel(private val messageService: MessageService) : ViewModel() {

    fun onClick() {
        this.messageService.information("onClicked!!!!")
    }

}