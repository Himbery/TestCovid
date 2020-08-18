package com.edy21.corona19.mvp;

import androidx.annotation.NonNull;

import com.edy21.corona19.Model.CountriesModel;
import com.edy21.corona19.Model.Global;

import java.util.List;

public class Presenter implements Contract.Presenter {
    public Contract.View viewMain;
    public Contract.Model model;
    String today;

    public Presenter(Contract.View view){
        viewMain = view;
        model = new Model();
    }

    @Override
    public void onSuccess(@NonNull List<CountriesModel> list) {
        viewMain.showCountries(list);

    }

    @Override
    public void onSuccessG(@NonNull Global o) {
        viewMain.showResults(o);

    }

    @Override
    public void onError(@NonNull Throwable throwable) {

    }

    @Override
    public void getData() {
        today = model.getDateToday();
        viewMain.showDate(today);
        model.getData(this);
        model.getGlobalData(this);

    }
}
