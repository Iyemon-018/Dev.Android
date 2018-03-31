package com.example.iyemon018.preferencesample

import com.os.operando.garum.annotations.Pref
import com.os.operando.garum.annotations.PrefKey
import com.os.operando.garum.models.PrefModel

@Pref()
class GeneralPrefModel : PrefModel() {
    @PrefKey("example_text")
    public var exampleText: String = ""

    @PrefKey("example_list")
    public var exampleList: String = ""

    @PrefKey("example_switch")
    public var exampleSwitch: Boolean = false
}