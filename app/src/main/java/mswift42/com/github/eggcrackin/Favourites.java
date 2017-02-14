package mswift42.com.github.eggcrackin;


import java.util.ArrayList;
import java.util.List;

public class Favourites {
    private static List<Recipe> recipes = new ArrayList<>();

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    public void addFavourite(Recipe recipe) {
        recipes.add(recipe);
    }

    public void deleteFavourite(Recipe recipe) {
        recipes.remove(recipe);
    }

    public static boolean isFavourite(Recipe recipe) {
        return recipes.contains(recipe);
    }

}
