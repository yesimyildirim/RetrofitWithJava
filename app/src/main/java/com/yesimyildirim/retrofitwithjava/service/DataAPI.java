package com.yesimyildirim.retrofitwithjava.service;

import com.yesimyildirim.retrofitwithjava.model.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataAPI {
    @GET("hisse/list")
    Call<DataModel> verilerimilistele();
}
