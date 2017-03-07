package mswift42.com.github.eggcrackin;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
public class FavouritesUnitTest {
    @Test
    public void favourites_set_empty_recipe_list() throws Exception {
        Favourites favs = new Favourites();
        assertEquals(favs.getRecipes().size(), 0);
    }

    @Test
    public void setrecipes_sets_recipes_to_favourites_list() throws Exception {
        Favourites favs = new Favourites();
        favs.setRecipes(MockRecipeData.getRecipes());
        assertEquals(favs.getRecipes().size(), 5);
    }

    @Test
    public void addFavourites_adds_recipe_to_favourites() throws Exception {
        Favourites favs = new Favourites();
        List<Recipe> mr = MockRecipeData.getRecipes();
        favs.addFavourite(mr.get(0));
        assertEquals(favs.getRecipes().size(),1);
    }
}
