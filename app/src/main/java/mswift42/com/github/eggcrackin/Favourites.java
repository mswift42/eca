package mswift42.com.github.eggcrackin;


import android.os.Environment;
import android.util.JsonWriter;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Favourites {
    private static List<Recipe> recipes = new ArrayList<>();

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public static void setRecipes(List<Recipe> recipes) {
        recipes = recipes;
    }
    public static void addFavourite(Recipe recipe) {
        recipes.add(recipe);
    }

    public static void deleteFavourite(Recipe recipe) {
        recipes.remove(recipe);
    }

    public static boolean isFavourite(Recipe recipe) {
        return recipes.contains(recipe);
    }

    public void saveFavourites() {
        File folderPath = Environment.getExternalStorageDirectory();
        File savedfavourites = new File(folderPath, "favourites.json");
        try {
            FileOutputStream fop = new FileOutputStream(savedfavourites);
            if (!savedfavourites.exists()) {
                savedfavourites.createNewFile();
                writeJsonStream(fop, recipes);
                fop.flush();
                fop.close();
            }
        } catch (IOException e) {
            Log.d("TAG", e.toString());
        }


     }
    private void writeJsonStream(OutputStream out, List<Recipe> recipelist) throws IOException {
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
        writer.setIndent("  ");
        writeRecipesArray(writer, recipelist);
    }
    private void writeRecipesArray(JsonWriter writer, List<Recipe> recipelist) throws IOException {
        writer.beginArray();
        for (Recipe recipe : recipelist) {
            writeRecipe(writer, recipe);
        }
        writer.endArray();
    }

    private void writeRecipe(JsonWriter writer, Recipe recipe) throws IOException {
        writer.beginObject();
        writer.name("publisher").value(recipe.getPublisher());
        writer.name("title").value(recipe.getTitle());
        writer.name("source_url").value(recipe.getSource_url());
        writer.name("image_url").value(recipe.getImage_url());
        writer.name("publisher_url").value(recipe.getPublisher_url());
        writer.name("recipe_id").value(recipe.getRecipe_id());
        if (recipe.getIngredients() != null) {
            writer.name("ingredients");
            writeStringArray(writer, recipe.getIngredients());
        }
        writer.close();
    }

    private void writeStringArray(JsonWriter writer, String[] ingredients) throws IOException {
        writer.beginArray();
        for (String ingredient : ingredients) {
            writer.value(ingredient);
        }
        writer.endArray();
    }


}
