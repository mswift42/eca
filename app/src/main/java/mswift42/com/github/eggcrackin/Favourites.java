package mswift42.com.github.eggcrackin;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class Favourites implements Parcelable {
    private static final Favourites ourInstance = new Favourites();
    private ArrayList<Recipe> favourites = new ArrayList<>();

    public static Favourites getInstance() {
        return ourInstance;
    }

    private Favourites() {
    }



    public ArrayList<Recipe> getFavourites() {
        return this.favourites;
    }

    public void setFavourites(ArrayList<Recipe> recipes) {
        favourites = recipes;
    }

    public void addFavourite(Recipe recipe) {
        if (!(isFavourite(recipe))) {
            favourites.add(recipe);
        }
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
// TODO set favourites list with gson data.
    public void setRecipesFromJson(String json) {
        Gson gson = new Gson();
        Favourites favs = gson.fromJson(json,
                mswift42.com.github.eggcrackin.Favourites.class);
        favourites = favs.getFavourites();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.favourites);
    }

    protected Favourites(Parcel in) {
        this.favourites = in.createTypedArrayList(Recipe.CREATOR);
    }

    public static final Parcelable.Creator<Favourites> CREATOR = new Creator<Favourites>() {
        @Override
        public Favourites createFromParcel(Parcel source) {
            return new Favourites(source);
        }

        @Override
        public Favourites[] newArray(int size) {
            return new Favourites[size];
        }
    };
}
