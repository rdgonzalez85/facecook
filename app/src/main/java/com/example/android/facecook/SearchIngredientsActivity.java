package com.example.android.facecook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.android.facecook.helpers.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;


public class SearchIngredientsActivity extends AppCompatActivity {

    final private ArrayList<Ingredient> selectedIngredients = new ArrayList<>();
    private TextView ingredientsQuantity;
    private Button continueButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ingredients);

        ingredientsQuantity = (TextView) findViewById(R.id.quantity_ingredient);

        final List<Ingredient> ingredients = getIngredients();

        RecyclerView ingredientsView = (RecyclerView) findViewById(R.id.ingredients_list);

        IngredientsAdapter adapter = new IngredientsAdapter(this, ingredients, selectedIngredients);

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
                    updateQuantityValue();
                    enableContinueButton();
                    checkBox.setChecked(!isChecked);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        continueButton = (Button) findViewById(R.id.continue_button);
        continueButton.setEnabled(false);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchIngredientsActivity.this, RecipesActivity.class);
                intent.putParcelableArrayListExtra("ingredients", selectedIngredients);
                startActivity(intent);
            }
        });
    }

    private void updateQuantityValue() {
        String quantity = selectedIngredients.size() + " " + getString(R.string.itemsSelected);
        ingredientsQuantity.setText(quantity);
    }

    private void enableContinueButton(){
        continueButton.setEnabled(selectedIngredients.size() > 0);
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
        ingredients.add(new Ingredient("Meat"));
        ingredients.add(new Ingredient("Apple"));
        ingredients.add(new Ingredient("Avocado"));
        ingredients.add(new Ingredient("Potato"));
        ingredients.add(new Ingredient("Chicken"));
        ingredients.add(new Ingredient("Olive"));

        return ingredients;
    }
}
