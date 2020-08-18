package com.edy21.corona19;

import com.edy21.corona19.Model.Coronamodel;
import com.edy21.corona19.Model.CountriesModel;
import com.edy21.corona19.Model.Global;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface CoronaApi {

    @GET("/countries")
    Call<List<CountriesModel>> call();

    @GET("/all")
    Call<Global> callGlobal();
}
