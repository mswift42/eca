package mswift42.com.github.eggcrackin;

import com.google.gson.Gson;

import java.util.Collection;
import java.util.HashSet;


public class Favourites {
    private static final Favourites ourInstance = new Favourites();
    private Collection<Recipe> favourites = new HashSet<>();

    public static Favourites getInstance() {
        return ourInstance;
    }

    private Favourites() {
    }


    public Collection<Recipe> getFavourites() {
        return this.favourites;
    }

    public void setFavourites(Collection<Recipe> recipeset) {
        favourites = recipeset;
    }

    public void addFavourite(Recipe recipe) {
        favourites.add(recipe);
    }

    public boolean deleteFavourite(Recipe recipe) {
        return this.favourites.remove(recipe);
    }

    public boolean isFavourite(Recipe recipe) {
        return favourites.contains(recipe);
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
