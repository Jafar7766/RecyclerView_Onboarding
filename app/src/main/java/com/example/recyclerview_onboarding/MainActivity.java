package com.example.recyclerview_onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler_view;
    RecyclerAdapter recyclerAdapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_view = findViewById(R.id.recycler_view);
        setRv();

    }
    private void setRv(){
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recycler_view.setLayoutManager(layoutManager);
        recyclerAdapter = new RecyclerAdapter(this);
        recycler_view.setAdapter(recyclerAdapter);

        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recycler_view);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (layoutManager.findLastCompletelyVisibleItemPosition() < (recyclerAdapter.getItemCount() - 1)) {
                    layoutManager.smoothScrollToPosition(recycler_view, new RecyclerView.State(), layoutManager.findFirstCompletelyVisibleItemPosition() + 1);
                } else if (layoutManager.findLastCompletelyVisibleItemPosition() < (recyclerAdapter.getItemCount() - 1)) {
                    layoutManager.smoothScrollToPosition(recycler_view, new RecyclerView.State(),  0);
                }
            }
            }, 0, 5500);
    }
}