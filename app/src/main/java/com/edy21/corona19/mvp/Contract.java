package com.edy21.corona19.mvp;

import androidx.annotation.NonNull;

import com.edy21.corona19.Model.CountriesModel;
import com.edy21.corona19.Model.Global;

import java.util.List;

public interface Contract {

   interface Model{
        void getData(Presenter presenter);
        void getGlobalData(Presenter presenter);
        String getDateToday();
    }
    interface Presenter{

        void onSuccess(@NonNull List<CountriesModel> list);
        void onSuccessG(@NonNull Global global);
        void onError(@NonNull Throwable throwable);
        void getData();

    }
    interface View{
        void showDate(String text);
        void showCountries(List list);
        void showResults(Global o);

    }
}
