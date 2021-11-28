package com.example.recipes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder> {
    private final LinkedList<String> mRecipeList, mSummaryList;
    private LayoutInflater mInflater;

    public RecipesAdapter(Context context, LinkedList<String> recipeList, LinkedList<String> summaryList) {
        mInflater = LayoutInflater.from(context);
        this.mRecipeList = recipeList;
        this.mSummaryList = summaryList;
    }

    @NonNull
    @Override
    public RecipesAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipes_item, parent, false);
        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesAdapter.RecipeViewHolder holder, int position) {
        String mCurrentRecipe = mRecipeList.get(position);
        String mCurrentSummary = mSummaryList.get(position);
        holder.recipeTittleItemView.setText(mCurrentRecipe);
        holder.recipeSummaryItemView.setText(mCurrentSummary);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView recipeTittleItemView;
        public final TextView recipeSummaryItemView;
        final RecipesAdapter mAdapter;

        public RecipeViewHolder(View itemView, RecipesAdapter mAdapter) {
            super(itemView);
            recipeTittleItemView = itemView.findViewById(R.id.title_recipe);
            recipeSummaryItemView = itemView.findViewById(R.id.summary_recipe);
            this.mAdapter = mAdapter;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item clicked
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mRecipeList
            String element = mRecipeList.get(mPosition);

            String message = "Recipe " + mPosition + " clicked";
            Toast.makeText(itemView.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
