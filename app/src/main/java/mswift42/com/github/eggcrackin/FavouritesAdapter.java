package mswift42.com.github.eggcrackin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
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
    public FavouritesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.favourite_card;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediateley = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediateley);
        FavouritesViewHolder viewHolder = new FavouritesViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    class FavouritesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public FavouritesViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View v) {
            int onClickedPosition = getAdapterPosition();
        }
    }
}
