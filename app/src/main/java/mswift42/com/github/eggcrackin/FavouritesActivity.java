package mswift42.com.github.eggcrackin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class FavouritesActivity extends AppCompatActivity implements FavouritesAdapter.ListItemClickListener {

    private FavouritesAdapter mAdapter;
    private RecyclerView mFavourites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        mFavourites = (RecyclerView) findViewById(R.id.ec_favourites_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mFavourites.setLayoutManager(layoutManager);

        mAdapter = new FavouritesAdapter(Favourites.getInstance().getFavourites().size(), this);
        mFavourites.setAdapter(mAdapter);

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}
