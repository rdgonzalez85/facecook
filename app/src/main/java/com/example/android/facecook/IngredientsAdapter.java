package com.example.android.facecook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
        public CheckBox ingredientCheckBox;

        public ViewHolder(View itemView) {
            super(itemView);
            ingredientImage = (ImageView) itemView.findViewById(R.id.ingredient_image);
            ingredientName = (TextView) itemView.findViewById(R.id.ingredient_name);
            ingredientCheckBox = (CheckBox) itemView.findViewById(R.id.ingredient_check);
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

        View ingredientView = inflater.inflate(R.layout.item_ingredient, parent, false);
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

        CheckBox ingredientCheckBox = holder.ingredientCheckBox;
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
