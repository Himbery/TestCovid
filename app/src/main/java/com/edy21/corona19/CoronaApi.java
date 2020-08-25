package com.edy21.corona19;

import com.edy21.corona19.Model.CountriesModel;
import com.edy21.corona19.Model.Global;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CoronaApi {

    @GET("/countries")
    Observable<List<CountriesModel>> call();

    @GET("/all")
    Observable<Global> callGlobal();
}
