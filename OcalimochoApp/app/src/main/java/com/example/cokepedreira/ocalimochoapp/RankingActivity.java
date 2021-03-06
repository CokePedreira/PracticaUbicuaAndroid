package com.example.cokepedreira.ocalimochoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RankingActivity extends BaseActivity {

    @Bind(R.id.ranking_list_view) ListView rankingListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        ButterKnife.bind(this);

        ArrayList<String> ranking = new Gson().fromJson(getIntent().getStringExtra("ranking"), new TypeToken<ArrayList<String>>(){}.getType());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ranking);
        rankingListView.setAdapter(arrayAdapter);
    }
}
