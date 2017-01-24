package com.example.android.facecook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SearchIngredientsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ingredients);

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Tomatoes"));
        ingredients.add(new Ingredient("Lettuce"));
        ingredients.add(new Ingredient("Rice"));
        ingredients.add(new Ingredient("Carrots"));
        ingredients.add(new Ingredient("Tomatoes"));
        ingredients.add(new Ingredient("Tomatoes"));
        ingredients.add(new Ingredient("Tomatoes"));
        ingredients.add(new Ingredient("Tomatoes"));
        ingredients.add(new Ingredient("Tomatoes"));
        ingredients.add(new Ingredient("Tomatoes"));

        RecyclerView ingredientsView = (RecyclerView) findViewById(R.id.ingredients_list);

        IngredientsAdapter adapter = new IngredientsAdapter(this, ingredients);

        ingredientsView.setAdapter(adapter);

        ingredientsView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setIconifiedByDefault(false);
        searchView.setIconified(false);
        searchView.setQueryHint(getString(R.string.searchIngredients));
        searchView.requestFocus();
        return true;
    }

}
