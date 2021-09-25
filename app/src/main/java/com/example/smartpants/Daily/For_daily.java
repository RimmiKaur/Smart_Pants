package com.example.smartpants.Daily;

import com.example.smartpants.MetaData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class For_daily {

    @SerializedName("Meta Data")
    @Expose
    private MetaData metaData;
    @SerializedName("Time Series (Daily)")
    @Expose
    private TimeSeriesDaily timeSeriesDaily;

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public TimeSeriesDaily getTimeSeriesDaily() {
        return timeSeriesDaily;
    }

    public void setTimeSeriesDaily(TimeSeriesDaily timeSeriesDaily) {
        this.timeSeriesDaily = timeSeriesDaily;
    }

}
