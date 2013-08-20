package com.gepsens.restorius.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.gepsens.restorius.R;
import com.gepsens.restorius.model.Recipe;
import com.loopj.android.image.SmartImageView;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;

public class RecipesAdapter extends ArrayAdapter<Recipe> {

    private final Context mContext;
    private final List<Recipe> mRecipes;
    private final ArrayList<ParseObject> mRecipeRelations;
    private final LayoutInflater mInflater;


    public RecipesAdapter(Context context, List<Recipe> recipes, ArrayList<ParseObject> recipeRelations) {
        super(context, R.layout.recipe_grid_item, recipes);
        mContext = context;
        mRecipes = recipes;
        mRecipeRelations = recipeRelations;
        mInflater = LayoutInflater.from(mContext);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        RecipeViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.recipe_grid_item, null);

            holder = new RecipeViewHolder();
            holder.thumbnail = (SmartImageView) convertView.findViewById(R.id.recipeImg);
            convertView.setTag(holder);
        }
        else {
            holder = (RecipeViewHolder) convertView.getTag();
        }

        final Recipe recipe = mRecipes.get(position);

        holder.thumbnail.setImageUrl(recipe.getThumbnail().getUrl());

        return convertView;
    }

    private static class RecipeViewHolder {

        public SmartImageView thumbnail;
    }

}
