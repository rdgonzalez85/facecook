package com.example.android.facecook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by raulrashuaman on 2/6/17.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private List<Recipe> mRecipes;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView recipeImage;
        public TextView recipeTitle;
        public TextView recipeDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            recipeImage = (ImageView) itemView.findViewById(R.id.recipe_image);
            recipeTitle = (TextView) itemView.findViewById(R.id.recipe_title);
            recipeDescription = (TextView) itemView.findViewById(R.id.recipe_description);
        }
    }

    public RecipeAdapter(Context context, List<Recipe> recipes) {
        mContext = context;
        mRecipes = recipes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View recipeView = inflater.inflate(R.layout.item_recipe, parent, false);
        ViewHolder viewHolder = new ViewHolder(recipeView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Recipe recipe = mRecipes.get(position);

        ImageView recipeImage = holder.recipeImage;
        TextView recipeTitle = holder.recipeTitle;
        TextView recipeDescription = holder.recipeDescription;

        Picasso.with(mContext).load(recipe.getUrlImage()).into(recipeImage);
        recipeTitle.setText(recipe.getTitle());
        recipeDescription.setText(recipe.getDescription());
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }
}
