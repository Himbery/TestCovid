package com.edy21.corona19.mvp;

import com.edy21.corona19.CoronaApi;
import com.edy21.corona19.Model.CountriesModel;
import com.edy21.corona19.Model.Global;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model implements Contract.Model {

    @Override
    public void getData(Contract.Presenter presenter) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://coronavirus-19-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        CoronaApi api = retrofit.create(CoronaApi.class);

        Call<List<CountriesModel>> call = api.call();
        call.enqueue(new Callback<List<CountriesModel>>() {
            @Override
            public void onResponse(Call<List<CountriesModel>> call, Response<List<CountriesModel>> response) {
                if (response.isSuccessful()){
                    List<CountriesModel> countriesModels = response.body();
                    presenter.onSuccess(countriesModels);
                }
            }

            @Override
            public void onFailure(Call<List<CountriesModel>> call, Throwable t) {
                presenter.onError(t);
            }
        });
    }

    @Override
    public void getGlobalData(Contract.Presenter presenter) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://coronavirus-19-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        CoronaApi api = retrofit.create(CoronaApi.class);

        Call<Global> call = api.callGlobal();
        call.enqueue(new Callback<Global>() {
            @Override
            public void onResponse(Call<Global> call, Response<Global> response) {
                if (response.isSuccessful()){
                    Global global = response.body();
                    presenter.onSuccessG(global);
                }
            }

            @Override
            public void onFailure(Call<Global> call, Throwable t) {
                presenter.onError(t);
            }
        });
    }

    @Override
    public String getDateToday() {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);
        return dateText;
    }
}
