package mswift42.com.github.eggcrackin;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockRecipeData {
    public final static List<Recipe> recipes = new ArrayList<>(Arrays.asList(
            new Recipe(
                    "The Pioneer Woman",
                    "French Toast",
                    "http://www.simplyrecipes.com/recipes/french_toast/",
                    R.drawable.frenchtoast300200,
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
                    R.drawable.frenchonionstuffedmushrooms,
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
                    }),
            new Recipe(
                    "All Recipes",
                    "Easy Slow Cooker French Dip",
                    "http://allrecipes.com/Recipe/Easy-Slow-Cooker-French-Dip/Detail.aspx",
                    R.drawable.easyslowcookerfrenchdip,
                    "http://allrecipes.com",
                    "12360",
                    new String[]{
                            "4 pounds rump roast",
                            "1 can beef broth",
                            "1 can condensed French onion soup",
                            "1 bottle beer",
                            "6 french rolls",
                            "2 tablespoons butter"
                    }),
            new Recipe(
                    "Closet Cooking",
                    "Pumpkin Pie French Toast",
                    "http://www.closetcooking.com/2009/11/pumpkin-pie-french-toast.html",
                    R.drawable.pumpkinpiefrenchtoast,
                    "http://closetcooking.com",
                    "35499",
                    new String[]{
                            "2 eggs",
                            "1/4 cup milk",
                            "1/4 cup pumpkin puree",
                            "1/4 teaspoon vanilla",
                            "1/2 teaspoon cinnamon",
                            "1/4 teaspoon ginger",
                            "1/8 teaspoon cloves",
                            "1/8 teaspoon nutmeg",
                            "2 tablespoons browhn sugar",
                            "8 slices of bread"
                    }),
            new Recipe(
                    "The Pioneer Woman",
                    "Perfect French Fries",
                    "http://thepioneerwoman.com/cooking/2012/01/perfect-french-fries/",
                    R.drawable.frenchfries,
                    "http://thepioneerwoman.com",
                    "46959",
                    new String[]{
                            "5 pounds Russet Potatoes",
                            "Vegetable Or Peanut Oil For Frying",
                            "Sea Salt"
                    })
    ));

    public static  List<Recipe> getRecipes() {
        return recipes;
    }
}
