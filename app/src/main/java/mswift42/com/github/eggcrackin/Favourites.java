package mswift42.com.github.eggcrackin;



import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Favourites {
    private Collection<Recipe> favourites = new HashSet<>();


    // TODO - Change to Set.

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

    private void fromJson(String json) {
        Gson gson = new Gson();
        Favourites favourites = gson.fromJson(json, Favourites.class);
        setFavourites(favourites.getFavourites());
    }

    // TODO add writeToFile method.
    // TODO add restoreFromFile method.

//    public void saveFavourites() {
//        File folderPath = Environment.getExternalStorageDirectory();
//        File savedfavourites = new File(folderPath, "favourites.json");
//        try {
//            FileOutputStream fop = new FileOutputStream(savedfavourites);
//            if (!savedfavourites.exists()) {
//                savedfavourites.createNewFile();
//                (fop, favourites);
//                fop.flush();
//                fop.close();
//            }
//        } catch (IOException e) {
//            Log.d("TAG", e.toString());
//        }
//
//
//    }


}
