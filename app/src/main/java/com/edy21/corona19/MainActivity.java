package com.edy21.corona19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;
import android.widget.TextView;

import com.edy21.corona19.Model.CountriesModel;
import com.edy21.corona19.Model.Global;
import com.edy21.corona19.mvp.Contract;
import com.edy21.corona19.mvp.Presenter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.View {
    Contract.Presenter presenter;
    Contract.Model model;
    String today;
    RecyclerView countriesList;
    TextView date;
    CountryAdapter adapter;
    Global global = new Global();
    TextView confirmed, recovered, death;
    List<CountriesModel> countries = new ArrayList<>();
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = (TextView) findViewById(R.id.date_today);
        countriesList = (RecyclerView) findViewById(R.id.list_country);
        recovered = findViewById(R.id.recovered);
        confirmed = findViewById(R.id.confirmed);
        death = findViewById(R.id.death);

        presenter = new Presenter(this);
        presenter.getData();
    }

    @Override
    public void showDate(String text) {
      date.setText(text);
    }

    @Override
    public void showCountries(List list) {
        countriesList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CountryAdapter(MainActivity.this, list);
        countriesList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showResults(Global o) {
        global = o;
        int totalR = global.recovered;
        int totalD = global.deaths;
        int totalC = global.cases;
        recovered.setText("Recovered - " + String.valueOf(totalR));
        confirmed.setText("Diseased - " + String.valueOf(totalC));
        death.setText("Deaths - " + String.valueOf(totalD));

    }
}
