package com.nokia.ndac.ecs.countrydemoapp.ui.main;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nokia.ndac.ecs.countrydemoapp.CountryDemoApplication;
import com.nokia.ndac.ecs.countrydemoapp.R;
import com.nokia.ndac.ecs.countrydemoapp.model.Country;
import com.nokia.ndac.ecs.countrydemoapp.model.RestResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.main_swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.main_list_layout)
    RecyclerView listLayout;
    @BindView(R.id.main_placeholder)
    TextView placeHolder;
    @BindView(R.id.main_message)
    TextView message;
    @BindView(R.id.main_search_field)
    EditText searchField;
    @BindView(R.id.main_search_button)
    Button searchButton;

    private List<Country> countryList;
    private CountriesAdapter countriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountryDemoApplication.injector.inject(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);

        initScreen();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public Context getContext() {
        return this.getBaseContext();
    }

    @OnClick(R.id.main_search_button)
    public void onSearchButtonClicked() {
        mainPresenter.getCountries(searchField.getText().toString());
    }

    @Override
    public void showResponse(RestResponse response) {
        if (swipeLayout != null) {
            swipeLayout.setRefreshing(false);
        }

        message.setText(response.getMessages().get(0));

        countryList.clear();
        countryList.addAll(response.getCountries());
        countriesAdapter.notifyDataSetChanged();

        if (countryList.isEmpty()) {
            listLayout.setVisibility(View.GONE);
            placeHolder.setVisibility(View.VISIBLE);
        } else {
            listLayout.setVisibility(View.VISIBLE);
            placeHolder.setVisibility(View.GONE);
        }
    }

    private void initScreen() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listLayout.setLayoutManager(llm);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainPresenter.getCountries("");
            }
        });

        countryList = new ArrayList<>();
        countriesAdapter = new CountriesAdapter(this, countryList);
        listLayout.setAdapter(countriesAdapter);

        mainPresenter.getCountries("");
    }
}
