package com.nokia.ndac.ecs.countrydemoapp.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nokia.ndac.ecs.countrydemoapp.R;
import com.nokia.ndac.ecs.countrydemoapp.model.Country;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder> {

    private Context context;
    private List<Country> countryList;

    public CountriesAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_country, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.tvName.setText(country.getName());
        holder.tvAlpha2.setText(country.getAlpha2_code());
        holder.tvAlpha3.setText(country.getAlpha3_code());
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public Country getCountry(int position) {
        return countryList.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.card_country_image)
        ImageView ivImage;
        @BindView(R.id.card_country_name)
        TextView tvName;
        @BindView(R.id.card_country_alpha2)
        TextView tvAlpha2;
        @BindView(R.id.card_country_alpha3)
        TextView tvAlpha3;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "hello click", Toast.LENGTH_SHORT).show();
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(v.getContext(), "hello loooooooong click", Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
    }
}