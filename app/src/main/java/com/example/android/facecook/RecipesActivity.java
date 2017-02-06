package com.example.android.facecook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.facecook.helpers.MarginDecoration;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.facecook.R.string.recipes;

public class RecipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        ArrayList<Ingredient> ingredients = new ArrayList<>();

        if (getIntent().getExtras() != null) {
            ingredients = getIntent().getExtras().getParcelableArrayList("ingredients");
        }

        List<Recipe> recipes =  getRecipesForIngredients(ingredients);

        RecyclerView recipesView = (RecyclerView) findViewById(R.id.recipes_list);

        RecipeAdapter adapter = new RecipeAdapter(this, recipes);

        recipesView.addItemDecoration(new MarginDecoration(this));

        recipesView.setAdapter(adapter);

        recipesView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<Recipe> getRecipesForIngredients(List<Ingredient> ingredients) {
        List<Recipe> recipes = new ArrayList<>();

        // TODO: do the magic and return recipes that matches the search

        recipes.add(new Recipe("Title", "nanananana", "http://www.guiafotos.com/gastronomia/lomo-saltado/img/lomo2.jpg"));
        recipes.add(new Recipe("Title", "nanananana", "http://www.guiafotos.com/gastronomia/lomo-saltado/img/lomo2.jpg"));
        recipes.add(new Recipe("Title", "nanananana", "http://www.guiafotos.com/gastronomia/lomo-saltado/img/lomo2.jpg"));
        recipes.add(new Recipe("Title", "nanananana", "http://www.guiafotos.com/gastronomia/lomo-saltado/img/lomo2.jpg"));
        recipes.add(new Recipe("Title", "nanananana", "http://www.guiafotos.com/gastronomia/lomo-saltado/img/lomo2.jpg"));
        recipes.add(new Recipe("Title", "nanananana", "http://www.guiafotos.com/gastronomia/lomo-saltado/img/lomo2.jpg"));
        recipes.add(new Recipe("Title", "nanananana", "http://www.guiafotos.com/gastronomia/lomo-saltado/img/lomo2.jpg"));
        recipes.add(new Recipe("Title", "nanananana", "http://www.guiafotos.com/gastronomia/lomo-saltado/img/lomo2.jpg"));
        recipes.add(new Recipe("Title", "nanananana", "http://www.guiafotos.com/gastronomia/lomo-saltado/img/lomo2.jpg"));
        recipes.add(new Recipe("Title", "nanananana", "http://www.guiafotos.com/gastronomia/lomo-saltado/img/lomo2.jpg"));
        recipes.add(new Recipe("Title", "nanananana", "http://www.guiafotos.com/gastronomia/lomo-saltado/img/lomo2.jpg"));

        return recipes;
    }
}
