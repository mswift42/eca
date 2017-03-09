package mswift42.com.github.eggcrackin;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
public class FavouritesUnitTest {
    @Test
    public void favourites_set_empty_recipe_list() throws Exception {
        Favourites favs = new Favourites();
        assertEquals(favs.getFavourites().size(), 0);
    }

    @Test
    public void setrecipes_sets_recipes_to_favourites_list() throws Exception {
        Favourites favs = new Favourites();
        favs.setFavourites(MockRecipeData.getRecipes());
        assertEquals(favs.getFavourites().size(), 4);
    }

    @Test
    public void addFavourites_adds_recipe_to_favourites() throws Exception {
        Favourites favs = new Favourites();
        List<Recipe> mr = MockRecipeData.getRecipes();
        favs.addFavourite(mr.get(0));
        assertEquals(favs.getFavourites().size(),1);
    }

    @Test
    public void deleteFavourite_deletes_favourite() throws Exception {
        Favourites favs = new Favourites();
        List<Recipe> mr = MockRecipeData.getRecipes();
        favs.setFavourites(mr);
        assertEquals(favs.getFavourites().size(),5);
        boolean removed = favs.deleteFavourite(mr.get(0));
        assertTrue(removed);
        assertEquals(favs.getFavourites().size(),4);
    }

    @Test
    public void isFavourite_returns_correct_boolean() throws Exception {
        Favourites favs = new Favourites();
        List<Recipe> mr = MockRecipeData.getRecipes();
        favs.setFavourites(mr);
        assertTrue(favs.isFavourite(mr.get(0)));
    }
    // TODO add tests for toJSON / fromJSON methods.
}
