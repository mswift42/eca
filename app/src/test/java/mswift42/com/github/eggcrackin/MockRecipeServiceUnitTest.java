package mswift42.com.github.eggcrackin;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MockRecipeServiceUnitTest {
    @Test
    public void mockrecipedata_contains_recipe_list() throws Exception {
        List<Recipe> recipes = MockRecipeData.getRecipes();
        assertEquals(recipes.size(), 5);
        assertEquals(recipes.get(0).getTitle(), "French Toast");
    }
}