package mswift42.com.github.eggcrackin;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;


public class FavouritesAdapter extends RecyclerView.Adapter {

    final private ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    private List<Recipe> mFavourites = Favourites.getInstance().getFavourites();

    private static int viewHolderCount;
    private int mNumberItems;

    public FavouritesAdapter(int numberOfItems, ListItemClickListener listener) {
        mNumberItems = numberOfItems;
        mOnClickListener = listener;
        viewHolderCount = 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
