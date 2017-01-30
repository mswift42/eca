package mswift42.com.github.eggcrackin;


import android.content.Context;
import android.support.v4.view.ViewGroupCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder> {


    final private ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    private List<Recipe> mRecipes = MockRecipeData.getRecipes();

    private static int viewHolderCount;

    private int mNumberItems;

    public RecipesAdapter(int numberOfItems, ListItemClickListener listener) {
        mNumberItems = numberOfItems;
        mOnClickListener = listener;
        viewHolderCount = 0;
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    public RecipeViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.recipe_card;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);

        RecipeViewHolder viewHolder = new RecipeViewHolder(view);
        return viewHolder;

    }
    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        holder.bind(position);
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mRecipeTitle;

        void bind(int listIndex) {
            String title = MockRecipeData.getRecipes().get(listIndex).getTitle();
            mRecipeTitle.setText(title);
        }


        public RecipeViewHolder(View itemView) {
            super(itemView);

            mRecipeTitle = (TextView) itemView.findViewById(R.id.ec_recipe_title);
            mRecipeTitle.setText("hallo");
            // COMPLETED (7) Call setOnClickListener on the View passed into the constructor (use 'this' as the OnClickListener)
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int onClickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(onClickedPosition);
        }
    }

}
