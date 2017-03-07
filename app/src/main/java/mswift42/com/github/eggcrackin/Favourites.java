package mswift42.com.github.eggcrackin;


import android.os.Environment;
import android.util.JsonWriter;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Favourites {
    private static List<Recipe> recipes = new ArrayList<>();

    public Favourites() {
    }

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

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    private void fromJson(String json) {
        Gson gson = new Gson();
        Favourites favourites = gson.fromJson(json, Favourites.class);
        setRecipes(favourites.getRecipes());
    }

    public void saveFavourites() {
        File folderPath = Environment.getExternalStorageDirectory();
        File savedfavourites = new File(folderPath, "favourites.json");
        try {
            FileOutputStream fop = new FileOutputStream(savedfavourites);
            if (!savedfavourites.exists()) {
                savedfavourites.createNewFile();
                (fop, recipes);
                fop.flush();
                fop.close();
            }
        } catch (IOException e) {
            Log.d("TAG", e.toString());
        }


    }


}
