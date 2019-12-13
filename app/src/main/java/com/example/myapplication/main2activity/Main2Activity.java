package com.example.myapplication.main2activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.mainactivity.RvAdapter;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView rv = findViewById(R.id.main_rv);
        rv.setAdapter(new RvAdapter());
        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }
}
