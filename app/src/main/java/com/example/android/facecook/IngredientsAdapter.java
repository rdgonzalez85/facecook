package com.example.android.facecook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by raulrashuaman on 1/24/17.
 */

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.ViewHolder> {

    private List<Ingredient> mIngredients;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ingredientImage;
        public TextView ingredientName;
        public Button addIngredientButton;

        public ViewHolder(View itemView) {
            super(itemView);
            ingredientImage = (ImageView) itemView.findViewById(R.id.ingredient_image);
            ingredientName = (TextView) itemView.findViewById(R.id.ingredient_name);
            addIngredientButton = (Button) itemView.findViewById(R.id.add_button);
        }
    }

    public IngredientsAdapter(Context context, List<Ingredient> ingredients) {
        mContext = context;
        mIngredients = ingredients;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View ingredientView = inflater.inflate(R.layout.ingredient_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(ingredientView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Ingredient ingredient = mIngredients.get(position);

        ImageView ingredientImage = holder.ingredientImage;
        ingredientImage.setImageResource(R.mipmap.ic_launcher);

        TextView ingredientName = holder.ingredientName;
        ingredientName.setText(ingredient.getName());

        Button addIngredientButton = holder.addIngredientButton;
        addIngredientButton.setText(R.string.add);
    }

    @Override
    public int getItemCount() {
        return mIngredients.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
