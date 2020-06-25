package com.yesimyildirim.retrofitwithjava;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yesimyildirim.retrofitwithjava.model.DataModel;
import com.yesimyildirim.retrofitwithjava.model.Datum;
import com.yesimyildirim.retrofitwithjava.service.APIUrl;
import com.yesimyildirim.retrofitwithjava.service.DataAPI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Datum> data;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textdata);

        loadData();

       // https://web-paragaranti-pubsub.foreks.com/web-services/securities/exchanges/BIST/groups/E
    }
    private void loadData() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final DataAPI dataAPI= retrofit.create(DataAPI.class);
        Call<DataModel> call= dataAPI.verilerimilistele();
        call.enqueue(new Callback<DataModel>() {

            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                data=response.body().getData();
                textView.setText(data.toString());


            }
            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}