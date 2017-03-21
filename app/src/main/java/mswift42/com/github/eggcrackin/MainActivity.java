package mswift42.com.github.eggcrackin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

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
            Favourites.getInstance().setRecipesFromJson(restored);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        FileUtility.writeToFile(this, Favourites.getInstance().toJson());

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Toast toast = Toast.makeText(this, "recipe", Toast.LENGTH_SHORT);
        toast.show();

    }
}
