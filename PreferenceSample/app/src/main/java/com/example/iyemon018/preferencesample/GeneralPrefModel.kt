package com.example.iyemon018.preferencesample

import com.os.operando.garum.annotations.Pref
import com.os.operando.garum.annotations.PrefKey
import com.os.operando.garum.models.PrefModel

@Pref()
class GeneralPrefModel : PrefModel() {

    private var initialized: Boolean = false

    @PrefKey("example_text")
    public var exampleText: String = ""
        set(value) {
            if (this.initialized) {
                field = value
            } else {
                if (value != "") {
                    field = value
                }
            }
        }

    @PrefKey("example_list")
    public var exampleList: String = ""

    @PrefKey("example_switch")
    public var exampleSwitch: Boolean = false

    init {
        this.initialized = true
    }

}