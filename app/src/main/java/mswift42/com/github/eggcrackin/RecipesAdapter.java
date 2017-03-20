package mswift42.com.github.eggcrackin;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        LinearLayout mRecipeDetails;
        TextView mRecipeIngredients;
        ImageView mRecipeExpander;
        TextView mRecipePublisher;
        String[] ingredients;
        Boolean showDetails = false;

        void bind(int listIndex) {
            String title = mRecipes.get(listIndex).getTitle();
            int image = mRecipes.get(listIndex).getImage_url();
            mRecipeTitle.setText(title);
            mRecipeImage.setImageResource(image);
            ingredients = mRecipes.get(listIndex).getIngredients();
            boolean favourite = Favourites.getInstance().isFavourite(mRecipes.get(listIndex));
            mFavouriteIcon.setImageResource(favourite ? R.drawable.ic_favorite_black_24dp :
                    R.drawable.ic_favorite_border_black_24dp);
            String publisher = mRecipes.get(listIndex).getPublisher();
            mRecipePublisher.setText(publisher);
        }


        public RecipeViewHolder(View itemView) {
            super(itemView);

            mRecipeTitle = (TextView) itemView.findViewById(R.id.ec_recipe_title);
            mRecipeImage = (ImageView) itemView.findViewById(R.id.ec_recipe_image);
            // COMPLETED (7) Call setOnClickListener on the View passed into the constructor (use 'this' as the OnClickListener)
            mFavouriteIcon = (ImageView) itemView.findViewById(R.id.ec_favorite_icon_not_favourite);
            mFavouriteIcon.setOnClickListener(this);
            mRecipeIngredients = (TextView) itemView.findViewById(R.id.ec_recipe_ingredients);
            mRecipeDetails = (LinearLayout) itemView.findViewById(R.id.ec_recipe_details);
            mRecipePublisher = (TextView) itemView.findViewById(R.id.ec_recipe_publisher);
            mRecipeExpander = (ImageView) itemView.findViewById(R.id.ec_recipe_expander);
            mRecipeExpander.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toggleDetails();
                }
            });
        }

        private void toggleFavourite(int listIndex) {
            if (!(Favourites.getInstance().isFavourite(mRecipes.get(listIndex)))) {
                mFavouriteIcon.setImageResource(R.drawable.ic_favorite_black_24dp);
                Favourites.getInstance().addFavourite(mRecipes.get(listIndex));
            } else {
                mFavouriteIcon.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                Favourites.getInstance().deleteFavourite(mRecipes.get(listIndex));
            }
        }

        private void toggleDetails() {
            if (!showDetails) {
                mRecipeDetails.setVisibility(View.VISIBLE);
                mRecipeIngredients.setText(TextUtils.join("\n", ingredients));
                mRecipeExpander.setImageResource(R.drawable.ic_expand_less_black_24dp);
                showDetails = true;
            } else {
                mRecipeDetails.setVisibility(View.GONE);
                mRecipeExpander.setImageResource(R.drawable.ic_expand_more_black_24dp);
                showDetails = false;
            }

        }

        @Override
        public void onClick(View view) {
            int onClickedPosition = getAdapterPosition();
            toggleFavourite(onClickedPosition);
        }
    }

}
