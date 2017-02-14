package mswift42.com.github.eggcrackin;


import android.content.Context;
import android.media.Image;
import android.support.v4.view.ViewGroupCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        ImageView mRecipeImage;
        ImageView mFavouriteIcon;

        void bind(int listIndex) {
            String title = mRecipes.get(listIndex).getTitle();
            int image = mRecipes.get(listIndex).getImage_url();
            mRecipeTitle.setText(title);
            mRecipeImage.setImageResource(image);
            boolean favourite = Favourites.isFavourite(mRecipes.get(listIndex));
            mFavouriteIcon.setImageResource(favourite ? R.drawable.ic_favorite_black_24dp :
                    R.drawable.ic_favorite_border_black_24dp);
        }


        public RecipeViewHolder(View itemView) {
            super(itemView);

            mRecipeTitle = (TextView) itemView.findViewById(R.id.ec_recipe_title);
            mRecipeImage = (ImageView) itemView.findViewById(R.id.ec_recipe_image);
            // COMPLETED (7) Call setOnClickListener on the View passed into the constructor (use 'this' as the OnClickListener)
            mFavouriteIcon = (ImageView) itemView.findViewById(R.id.ec_favorite_icon_not_favourite);
            mFavouriteIcon.setOnClickListener(this);
        }

        private void toggleFavourite(int listIndex) {
            if (Favourites.isFavourite(mRecipes.get(listIndex))) {

                mFavouriteIcon.setImageResource(R.drawable.ic_favorite_black_24dp);
            } else {
                mFavouriteIcon.setImageResource(R.drawable.ic_favorite_border_black_24dp);
            }
        }

        @Override
        public void onClick(View view) {
            int onClickedPosition = getAdapterPosition();
            Favourites.addFavourite(mRecipes.get(onClickedPosition));
            toggleFavourite(onClickedPosition);
        }
    }

}
