package mswift42.com.github.eggcrackin;


import android.os.Parcel;
import android.os.Parcelable;

public class Recipe implements Parcelable {
    private  String publisher;
    private String title;
    private String source_url;
    private Integer image_url;
    private String publisher_url;
    private String recipe_id;
    private String[] ingredients;

    public Recipe(String publisher, String title,
                  String source_url, Integer image_url,
                  String publisher_url, String recipe_id, String[] ingredients) {
        this.publisher = publisher;
        this.title = title;
        this.source_url = source_url;
        this.image_url = image_url;
        this.publisher_url = publisher_url;
        this.recipe_id = recipe_id;
        this.ingredients = ingredients;
    }

    public static final Parcelable.Creator<Recipe> CREATOR =
            new Parcelable.Creator<Recipe>() {
                @Override
               public Recipe[] newArray(int size) {
                   return new Recipe[size];
               }
                @Override
               public Recipe createFromParcel(Parcel source) {
                   return new Recipe(source.readString(),
                           source.readString(),
                           source.readString(),
                           source.readInt(),
                           source.readString(),
                           source.readString(),
                           source.createStringArray());
               }
            };
    public Recipe() {
    }


    public String getRecipe_id() {
        return recipe_id;
    }

    public String getPublisher_url() {
        return publisher_url;
    }

    public Integer getImage_url() {
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

    public String[] getIngredients() {
        return ingredients;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(publisher);
        dest.writeString(title);
        dest.writeString(source_url);
        dest.writeInt(image_url);
        dest.writeString(publisher_url);
        dest.writeString(recipe_id);
        dest.writeStringArray(ingredients);
    }
}
