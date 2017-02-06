package com.example.android.facecook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.android.facecook.helpers.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.facecook.R.id.continueButton;

public class SearchIngredientsActivity extends AppCompatActivity {

    private ArrayList<Ingredient> selectedIngredients = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ingredients);

        final List<Ingredient> ingredients = getIngredients();


        selectedIngredients.add(new Ingredient("Tomatoes"));
        selectedIngredients.add(new Ingredient("Tomatoes"));
        selectedIngredients.add(new Ingredient("Tomatoes"));

        RecyclerView ingredientsView = (RecyclerView) findViewById(R.id.ingredients_list);

        IngredientsAdapter adapter = new IngredientsAdapter(this, ingredients);

        ingredientsView.setAdapter(adapter);

        ingredientsView.setLayoutManager(new LinearLayoutManager(this));

        ingredientsView.addOnItemTouchListener(new RecyclerTouchListener(this, ingredientsView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (ingredients != null) {
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.ingredient_check);
                    Ingredient ingredient = ingredients.get(position);
                    boolean isChecked = checkBox.isChecked();
                    if (!isChecked) {
                        selectedIngredients.add(ingredient);
                    } else {
                        selectedIngredients.remove(ingredient);
                    }
                    checkBox.setChecked(!isChecked);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        Button continueButton = (Button) findViewById(R.id.continue_button);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchIngredientsActivity.this, RecipesActivity.class);
                intent.putParcelableArrayListExtra("ingredients", selectedIngredients);
                startActivity(intent);
            }
        });
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

    private List<Ingredient> getIngredients() {
        // TODO: load

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

        return ingredients;
    }
}
