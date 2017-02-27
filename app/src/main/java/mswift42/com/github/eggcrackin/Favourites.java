package mswift42.com.github.eggcrackin;


import android.util.JsonWriter;

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

    public static void saveFavourites() {

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
            writer.close();
        }
    }


}
