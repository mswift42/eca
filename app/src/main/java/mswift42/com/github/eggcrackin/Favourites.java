package mswift42.com.github.eggcrackin;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class Favourites {
    private static final Favourites ourInstance = new Favourites();
    private ArrayList<String> favourites;

    public static Favourites getInstance() {
        return ourInstance;
    }

    private Favourites() {
    }


    public ArrayList<String> getFavourites() {
        return this.favourites;
    }

    public void setFavourites(ArrayList<String> recipeset) {
        favourites = recipeset;
    }

    public void addFavourite(Recipe recipe) {
        if (!(isFavourite(recipe))) {
            favourites.add(recipe.getRecipe_id());
        }
    }

    public boolean deleteFavourite(Recipe recipe) {
        return this.favourites.remove(recipe.getRecipe_id());
    }

    public boolean isFavourite(Recipe recipe) {
        return favourites.contains(recipe.getRecipe_id());
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(ourInstance);
    }

    public void setRecipesFromJson(String json) {
        Gson gson = new Gson();
        Favourites favs = gson.fromJson(json,
                mswift42.com.github.eggcrackin.Favourites.class);
        favourites = favs.getFavourites();
    }

}
