package mswift42.com.github.eggcrackin;



import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Favourites {
    private List<Recipe> recipes = new ArrayList<>();
    // TODO - Change to Set.

    public Favourites() {
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipelist) {
        recipes = recipelist;
    }

    public void addFavourite(Recipe recipe) {
        recipes.add(recipe);
    }

    public boolean deleteFavourite(Recipe recipe) {
        return recipes.remove(recipe);
    }

    public boolean isFavourite(Recipe recipe) {
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

    // TODO add writeToFile method.
    // TODO add restoreFromFile method.

//    public void saveFavourites() {
//        File folderPath = Environment.getExternalStorageDirectory();
//        File savedfavourites = new File(folderPath, "favourites.json");
//        try {
//            FileOutputStream fop = new FileOutputStream(savedfavourites);
//            if (!savedfavourites.exists()) {
//                savedfavourites.createNewFile();
//                (fop, recipes);
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
