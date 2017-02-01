package mswift42.com.github.eggcrackin;


import java.util.List;

public class Favourites {
    private List<Recipe> recipes;

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

}
