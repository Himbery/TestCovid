package com.edy21.corona19;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class TwoActivity extends AppCompatActivity {
    CardView c;
    TextView country, cases, deaths, recovered, casesAll, deathsAll, recoveredAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        c = (CardView) findViewById(R.id.body);
        cases = (TextView) findViewById(R.id.cases);
        casesAll = (TextView) findViewById(R.id.all_cases);
        deaths = (TextView) findViewById(R.id.deaths);
        deathsAll = (TextView) findViewById(R.id.all_deaths);
        recovered = (TextView) findViewById(R.id.recover);
        recoveredAll = (TextView) findViewById(R.id.all_recover);
        country = (TextView) findViewById(R.id.country);

        String name = getIntent().getStringExtra("name");
        int todayCases = getIntent().getIntExtra("newConfirmed", 0);
        int total = getIntent().getIntExtra("totalConfirmed", 0);
        int totalDeaths = getIntent().getIntExtra("totalDeaths", 0);
        int totalRecovered = getIntent().getIntExtra("totalRecovered", 0);
        int newDeaths = getIntent().getIntExtra("newDeaths", 0);

        country.setText(name + " (all/today)");
        cases.setText("Diseased  ");
        casesAll.setText(String.valueOf(total) + "(" + String.valueOf(todayCases) + ")");
        deaths.setText("Deaths  ");
        deathsAll.setText(String.valueOf(totalDeaths) + "(" + String.valueOf(newDeaths) + ")");
        recovered.setText("Recovered  ");
        recoveredAll.setText(String.valueOf(totalRecovered));

    }
}
