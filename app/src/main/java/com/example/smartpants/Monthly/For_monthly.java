package com.example.smartpants.Monthly;

import com.example.smartpants.MetaData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class For_monthly {
    @SerializedName("Meta Data")
    @Expose
    private MetaData metaData;
    @SerializedName("Monthly Time Series")
    @Expose
    private MonthlyTimeSeries monthlyTimeSeries;

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public MonthlyTimeSeries getMonthlyTimeSeries() {
        return monthlyTimeSeries;
    }

    public void setMonthlyTimeSeries(MonthlyTimeSeries monthlyTimeSeries) {
        this.monthlyTimeSeries = monthlyTimeSeries;
    }
}
