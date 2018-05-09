package com.example.iyemon018.preferencesample.pref;

import com.os.operando.garum.annotations.Pref;
import com.os.operando.garum.annotations.PrefKey;
import com.os.operando.garum.models.PrefModel;

@Pref
public final class GeneralPrefModel extends PrefModel {
    
    @PrefKey("example_text")
    public String exampleText;
    
    @PrefKey("example_list")
    public String exampleList;
    
    @PrefKey("example_switch")
    public boolean exampleSwitch;
}
