package mswift42.com.github.eggcrackin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecipeList.setLayoutManager(layoutManager);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Toast toast = Toast.makeText(this, "recipe", Toast.LENGTH_SHORT);
        toast.show();

    }
}
