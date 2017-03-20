package mswift42.com.github.eggcrackin;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
public class FavouritesUnitTest {
    @Test
    public void favourites_set_empty_recipe_list() throws Exception {
        assertEquals(Favourites.getInstance().getmFavourites().size(), 0);
    }

    @Test
    public void setrecipes_sets_recipes_to_favourites_list() throws Exception {
        Favourites.getInstance().setmFavourites(MockRecipeData.getRecipes());
        assertEquals(Favourites.getInstance().getmFavourites().size(), 5);

    }

    @Test
    public void addFavourites_adds_recipe_to_favourites() throws Exception {
        List<Recipe> mr = MockRecipeData.getRecipes();
        Favourites.getInstance().addFavourite(mr.get(0));
        assertEquals(Favourites.getInstance().getmFavourites().size(),1);
    }

    @Test
    public void deleteFavourite_deletes_favourite() throws Exception {
        List<Recipe> mr = MockRecipeData.getRecipes();
        Favourites.getInstance().setmFavourites(mr);
        assertEquals(Favourites.getInstance().getmFavourites().size(),5);
        boolean removed = Favourites.getInstance().deleteFavourite(mr.get(0));
        assertTrue(removed);
        assertEquals(Favourites.getInstance().getmFavourites().size(),4);
    }

    @Test
    public void isFavourite_returns_correct_boolean() throws Exception {
        List<Recipe> mr = MockRecipeData.getRecipes();
        Favourites.getInstance().setmFavourites(mr);
        assertTrue(Favourites.getInstance().isFavourite(mr.get(0)));
    }
}
// TODO add tests for toJSON / fromJSON methods.

//    @Test
//    public void toJson_returns_jsonstring() throws Exception {
//        Favourites favs = new Favourites();
//        favs.setFavourites(MockRecipeData.getRecipes());
//        String json = favs.toJson();
//        Favourites nfavs = new Favourites();
//        nfavs.fromJson(json);
//        assertEquals(nfavs.getFavourites().contains(MockRecipeData.getRecipes().get(0)), true);
//    }
//}
