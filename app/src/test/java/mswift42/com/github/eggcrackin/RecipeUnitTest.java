package mswift42.com.github.eggcrackin;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeUnitTest {
    @Test
    public void constructor_returns_valid_recipe_class() throws Exception {
        Recipe recipe = new Recipe("publisher", "title", "source_url", 0, "publisher_url",
                "recipe_id", new String[] {});
        assertEquals(recipe.getTitle(), "title");
        assertEquals(recipe.getPublisher(), "publisher");
        assertEquals(recipe.getImage_url(), new Integer(0));
    }
}
