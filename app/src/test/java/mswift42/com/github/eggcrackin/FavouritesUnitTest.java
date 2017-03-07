package mswift42.com.github.eggcrackin;


import org.junit.Test;
import static org.junit.Assert.*;
public class FavouritesUnitTest {
    @Test
    public void favourites_set_empty_recipe_list() throws Exception {
        Favourites favs = new Favourites();
        assertEquals(favs.getRecipes().size(), 0);
    }
}
