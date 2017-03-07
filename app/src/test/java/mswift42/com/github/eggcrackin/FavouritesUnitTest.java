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
        assertEquals(favs.getRecipes().size(), 4);
    }

    @Test
    public void addFavourites_adds_recipe_to_favourites() throws Exception {
        Favourites favs = new Favourites();
        List<Recipe> mr = MockRecipeData.getRecipes();
        favs.addFavourite(mr.get(0));
        assertEquals(favs.getRecipes().size(),1);
    }

    @Test
    public void deleteFavourite_deletes_favourite() throws Exception {
        Favourites favs = new Favourites();
        List<Recipe> mr = MockRecipeData.getRecipes();
        favs.setRecipes(mr);
        assertEquals(favs.getRecipes().size(),5);
        boolean removed = favs.deleteFavourite(mr.get(0));
        assertTrue(removed);
        assertEquals(favs.getRecipes().size(),4);
    }

    @Test
    public void isFavourite_returns_correct_boolean() throws Exception {
        Favourites favs = new Favourites();
        List<Recipe> mr = MockRecipeData.getRecipes();
        favs.setRecipes(mr);
        assertTrue(favs.isFavourite(mr.get(0)));
    }
}
