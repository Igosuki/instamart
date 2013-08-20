package com.gepsens.restorius;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gepsens.restorius.R;
import com.gepsens.restorius.adapters.RecipesAdapter;
import com.gepsens.restorius.model.Recipe;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class RecipeDashboardActivity extends Activity {

    private static final String TAG = "RecipeDashboardActivity";
    protected List<Recipe> mRecipes;
    protected ProgressBar mProgressBar;
    protected GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_search_grid);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        getRecipesInBackground();
    }

    private void getRecipesInBackground() {
        mProgressBar.setVisibility(View.VISIBLE);

        ParseQuery<Recipe> recipesQuery = ParseQuery.getQuery("Recipe");
        recipesQuery.whereEqualTo("uploader", "IM8SI7gGEC");
        recipesQuery.findInBackground(new FindCallback<Recipe>() {
            @Override
            public void done(List<Recipe> recipes, ParseException e) {
                if(e == null) {
                    RecipesAdapter adapter = new RecipesAdapter(RecipeDashboardActivity.this, mRecipes, null);
                    mGridView.setAdapter(adapter);
                } else {
                    Toast.makeText(RecipeDashboardActivity.this, "Problem fetching recipes", Toast.LENGTH_LONG).show();
                }
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.recipe_dashboard, menu);
        return true;
    }
    
}
