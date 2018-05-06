package com.pos.lejapinh.apps.calculadora;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ArrayList<String> results;
    ArrayAdapter<String> resultsAdapter;
    ListView lvHistories;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        InitializeComponents();
        results = getIntent().getStringArrayListExtra("History");
        resultsAdapter = new ArrayAdapter<String>(HistoryActivity.this, android.R.layout.simple_list_item_1, results);
        lvHistories.setAdapter(resultsAdapter);
    }

    private void InitializeComponents() {
        lvHistories = (ListView) findViewById(R.id.lvHistories);
        results = new ArrayList<>();
    }
}
