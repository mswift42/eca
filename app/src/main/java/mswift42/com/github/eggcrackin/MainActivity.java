package mswift42.com.github.eggcrackin;

import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements RecipesAdapter.ListItemClickListener {

    private RecipesAdapter mAdapter;
    private RecyclerView mRecipeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecipeList = (RecyclerView) findViewById(R.id.ec_recyclerview);
        int noOfColumns = SpanUtility.calculateNoOfColumns(this);
        LinearLayoutManager layoutManager = new GridLayoutManager(this, noOfColumns );
        mRecipeList.setLayoutManager(layoutManager);

        mAdapter = new RecipesAdapter(MockRecipeData.getRecipes().size(), this);
        mRecipeList.setAdapter(mAdapter);
        try {
            String restored = FileUtility.restoreFromFile(this);
            Log.i("FAVOURITESRESTORED", restored);
            Favourites.getInstance().setRecipesFromJson(restored);
            Log.i("FAVOURITESLIST", Favourites.getInstance().getFavourites().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("favourites",
                Favourites.getInstance().getFavourites());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<Recipe> favs = savedInstanceState.getParcelableArrayList("favourites");
        Favourites.getInstance().setFavourites(favs);

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Toast toast = Toast.makeText(this, "recipe", Toast.LENGTH_SHORT);
        toast.show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FileUtility.writeToFile(this, Favourites.getInstance().toJson());
    }
}
