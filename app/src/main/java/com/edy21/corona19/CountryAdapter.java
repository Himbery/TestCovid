package com.edy21.corona19;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.edy21.corona19.Model.CountriesModel;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    LayoutInflater inflater;
    List<CountriesModel> list;

    public CountryAdapter(Context context, List<CountriesModel> list){
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }
    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        return new CountryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, int position) {
        final CountriesModel countriesModel = list.get(position);
        holder.cityView.setText(countriesModel.country);
        holder.sumView.setText(String.valueOf(countriesModel.cases));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context c = holder.itemView.getContext();
                Intent intent = new Intent(c, TwoActivity.class);
                intent.putExtra("name", countriesModel.country);
                intent.putExtra("newConfirmed", countriesModel.todayCases);
                intent.putExtra("totalConfirmed", countriesModel.cases);
                intent.putExtra("totalDeaths", countriesModel.deaths);
                intent.putExtra("totalRecovered", countriesModel.recovered);
                intent.putExtra("newDeaths", countriesModel.todayDeaths);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView cityView, sumView;
        CardView cardView;
        ViewHolder(View view){
            super(view);
            cardView = (CardView) view.findViewById(R.id.body);
            cityView = (TextView) view.findViewById(R.id.name);
            sumView = (TextView) view.findViewById(R.id.sum);
        }
    }
}
