package mswift42.com.github.eggcrackin;



import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Favourites {
    private Collection<Recipe> favourites = new HashSet<>();
    String savedfavourites = "favourites.json";

    public Favourites() {
    }

    public Collection<Recipe> getFavourites() {
        return favourites;
    }

    public void setFavourites(Collection<Recipe> recipeset) {
        favourites = recipeset;
    }

    public void addFavourite(Recipe recipe) {
        favourites.add(recipe);
    }

    public boolean deleteFavourite(Recipe recipe) {
        return favourites.remove(recipe);
    }

    public boolean isFavourite(Recipe recipe) {
        return favourites.contains(recipe);
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public void fromJson(String json) {
        Gson gson = new Gson();
        Favourites favourites = gson.fromJson(json, Favourites.class);
        setFavourites(favourites.getFavourites());
    }
    // TODO add writeToFile method.
    // TODO add restoreFromFile method.

}
