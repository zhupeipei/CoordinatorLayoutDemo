package com.example.myapplication.main3activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.mainactivity.RvAdapter;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        findViewById(R.id.main_3_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main3Activity.this, "main_3_view", Toast.LENGTH_SHORT).show();
            }
        });

        TextView tv = findViewById(R.id.main_3_tv);
        tv.setText("main_3_tv");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main3Activity.this, "main_3_tv", Toast.LENGTH_SHORT);
            }
        });

        RecyclerView rv = findViewById(R.id.main_rv);
        rv.setAdapter(new RvAdapter());
        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }
}
