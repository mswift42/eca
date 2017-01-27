package mswift42.com.github.eggcrackin;


import android.support.v7.widget.RecyclerView;

public class RecipesViewAdapter extends RecyclerView.Adapter<> {


    final private ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    private static int viewHolderCount;

    private int mNumberItems;
}
