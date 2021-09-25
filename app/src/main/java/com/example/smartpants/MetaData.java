package com.example.smartpants;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetaData {

    @SerializedName("1. Information")
    @Expose
    private String _1Information;
    @SerializedName("2. Symbol")
    @Expose
    private String _2Symbol;
    @SerializedName("3. Last Refreshed")
    @Expose
    private String _3LastRefreshed;
    @SerializedName("4. Output Size")
    @Expose
    private String _4OutputSize;
    @SerializedName("5. Time Zone")
    @Expose
    private String _5TimeZone;

    public String get1Information() {
        return _1Information;
    }

    public void set1Information(String _1Information) {
        this._1Information = _1Information;
    }

    public String get2Symbol() {
        return _2Symbol;
    }

    public void set2Symbol(String _2Symbol) {
        this._2Symbol = _2Symbol;
    }

    public String get3LastRefreshed() {
        return _3LastRefreshed;
    }

    public void set3LastRefreshed(String _3LastRefreshed) {
        this._3LastRefreshed = _3LastRefreshed;
    }

    public String get4OutputSize() {
        return _4OutputSize;
    }

    public void set4OutputSize(String _4OutputSize) {
        this._4OutputSize = _4OutputSize;
    }

    public String get5TimeZone() {
        return _5TimeZone;
    }

    public void set5TimeZone(String _5TimeZone) {
        this._5TimeZone = _5TimeZone;
    }

}
