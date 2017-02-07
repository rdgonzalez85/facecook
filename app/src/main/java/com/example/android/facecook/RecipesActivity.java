package com.example.android.facecook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.facecook.helpers.MarginDecoration;

import java.util.ArrayList;
import java.util.List;

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

        recipes.add(new Recipe("Lomo saltado", "Es un plato típico de nuestra gastronomía peruana, que data desde fines del siglo XIX, conocido antes como lomito de vaca o lomito a la chorrillana. Surge por la influencia de los chinos-cantoneses, que fusionado con la sazón peruana, se ha convertido en uno de los platos más consumidos del país.", "http://www.guiafotos.com/gastronomia/lomo-saltado/img/lomo2.jpg"));
        recipes.add(new Recipe("Espaguetis en salsa Alfredo", "Se cuenta que estos espaguetis se hicieron famosos en Roma. El caso es que esta receta de espaguetis con salsa es tan famosa y fácil de preparar que no puedes perdértela. Aprende con RecetasGratis.net a cocinar los auténticos espaguetis en salsa Alfredo, una pasta con jamón con un sabor único. Un plato de pasta tradicional que seguro gusta a todos, en especial a los más pequeños de casa por su textura cremosa y su rico sabor.", "https://t2.rg.ltmcdn.com/es/images/7/7/0/img_espaguetis_en_salsa_alfredo_11077_600.jpg"));
        recipes.add(new Recipe("Lasagna", "Una mezcla de salchicha italiana y carne molida de res en una salsa de jitomate. La mezcla se alterna con hojas de lasagna, requesón y queso Mozzarela. Un poco laboriosa, pero vale la pena", "http://mxcdn.ar-cdn.com/recipes/xlarge/5a7cac81-7f63-401c-a2c3-9c0d2dde7b0e.jpg"));
        recipes.add(new Recipe("Pisco Sour", "Este cóctel, el más popular en el Perú, sobre todo en la costa está dándole mucho impulso a la produccion de Pisco, un licor tipo aguardiente con el cual se prepara esta receta. Se puede comprar en tiendas de productos peruanos o latinoamericanos. Ojo: que es peruano.", "http://walac.pe/wp-content/uploads/2016/02/El-origen-del-pisco-sour-en-peru-y-en-chile-1.jpg"));

        return recipes;
    }
}
