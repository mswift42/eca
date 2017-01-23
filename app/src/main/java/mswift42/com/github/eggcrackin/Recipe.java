package mswift42.com.github.eggcrackin;


import java.util.List;

public class Recipe {
    private  String publisher;
    private String title;
    private String source_url;
    private String image_url;

    public Recipe(String publisher, String title, String source_url, String image_url, String publisher_url, String recipe_id, List<String> ingredients) {
        this.publisher = publisher;
        this.title = title;
        this.source_url = source_url;
        this.image_url = image_url;
        this.publisher_url = publisher_url;
        this.recipe_id = recipe_id;
        this.ingredients = ingredients;
    }

    private String publisher_url;

    public String getRecipe_id() {
        return recipe_id;
    }

    public String getPublisher_url() {
        return publisher_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getSource_url() {
        return source_url;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    private String recipe_id;

    public List<String> getIngredients() {
        return ingredients;
    }

    private List<String> ingredients;
}
