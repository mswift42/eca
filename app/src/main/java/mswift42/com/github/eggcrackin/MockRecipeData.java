package mswift42.com.github.eggcrackin;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockRecipeData {
   public List<Recipe> recipes = new ArrayList<Recipe>(Arrays.asList(
    new Recipe(
             "The Pioneer Woman",
             "French Toast",
             "http://www.simplyrecipes.com/recipes/french_toast/",
             "http://static.food2fork.com/frenchtoast300x200b2da65d4.jpg",
            "http://www.simplyrecipes.com",
            "36355",
            new String[]{
                    "4 eggs",
                    "2/3 cup milk",
                    "2 teaspoons of cinnamon",
                    "8 thick slices of 2-day-old bread",
                    "Butter",
                    "Maple syrup",
                    "2 teaspoons freshly grated orange zest",
                    "1/4 cup Triple Sec",
                    "Fresh berries"
            }),
           new Recipe(
                    "The Pioneer Woman",
     "French Onion Soup Stuffed Mushrooms",
            "http://thepioneerwoman.com/cooking/2009/11/french-onion-soup-stuffed-mushrooms/",
     "http://static.food2fork.com/5200405868_e86da8e6e8_oceea.jpg",
     "http://thepioneerwoman.com",
     "47078",
     new String[]{
             "2 Tablespoons Butter",
             "2 whole Large Onions, Halved And Sliced Thin",
             "1/4 cub Beef Broth",
             "7 dashes Worcestershire Sauce",
             "Splash Of Red Or White Wine",
             "1/2 cub Grated Gruyere Cheese",
             "Salt",
             "24 whole White or Crimini Mushrooms",
             "Minced Parsley"
     })
            ));

}
