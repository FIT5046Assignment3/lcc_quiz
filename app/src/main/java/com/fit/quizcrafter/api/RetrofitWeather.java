package com.fit.quizcrafter.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitWeather {
    @GET("current")
    Call<ResponseBody> getWeatherbyLocation(@Query("access_key") String auth_key, @Query("query") String location);

}
