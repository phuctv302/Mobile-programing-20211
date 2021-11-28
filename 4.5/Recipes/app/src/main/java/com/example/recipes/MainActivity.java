package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mRecipeList = new LinkedList<>();
    private final LinkedList<String> mSummaryList = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private RecipesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initial data
        for (int i = 0; i < 20; i++) {
            mRecipeList.addLast(getString(R.string.recipe) + i);
            mSummaryList.addLast(getString(R.string.summary_tittle) + getString(R.string.summary_detail));
        }

        // Get a handle to the RecycleView
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new RecipesAdapter(this, mRecipeList, mSummaryList);
        // Connect the adapter with the RecycleView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}