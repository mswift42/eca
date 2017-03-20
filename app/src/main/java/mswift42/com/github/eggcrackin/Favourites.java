package mswift42.com.github.eggcrackin;

import com.google.gson.Gson;

import java.util.Collection;
import java.util.HashSet;


public class Favourites {
    private static final Favourites ourInstance = new Favourites();
    private Collection<Recipe> mFavourites = new HashSet<>();

    public static Favourites getInstance() {
        return ourInstance;
    }

    private Favourites() {
    }


    public Collection<Recipe> getmFavourites() {
        return this.mFavourites;
    }

    public void setmFavourites(Collection<Recipe> recipeset) {
        mFavourites = recipeset;
    }

    public void addFavourite(Recipe recipe) {
        mFavourites.add(recipe);
    }

    public boolean deleteFavourite(Recipe recipe) {
        return this.mFavourites.remove(recipe);
    }

    public boolean isFavourite(Recipe recipe) {
        return mFavourites.contains(recipe);
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
