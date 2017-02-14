package mswift42.com.github.eggcrackin;


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

}
