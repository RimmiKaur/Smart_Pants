package com.example.smartpants;

import com.example.smartpants.Daily.For_daily;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiservice {
    @GET("query")
    Call<For_daily> getallrecords(@Query("function") String function,
                                @Query("symbol") String symbol,
                                @Query("outputsize") String outputsize,
                                @Query("datatype") String datatype,
                                @Query("apikey") String apikey);
}
