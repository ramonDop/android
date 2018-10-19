package com.example.dropa.geoguesswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private GeoObjectAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<GeoObject> mGeoObjects = new ArrayList<>();

        for (int i = 0; i < GeoObject.PRE_DEFINED_GEO_IS_IN_EUROPE.length; i++) {

            mGeoObjects.add(new GeoObject(GeoObject.PRE_DEFINED_GEO_IS_IN_EUROPE[i],

                    GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i]));

        }
        RecyclerView mGeoRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        mGeoRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        mGeoRecyclerView.setAdapter(mAdapter);

        /*
        Add a touch helper to the RecyclerView to recognize when a user swipes to delete a list entry.
        An ItemTouchHelper enables touch behavior (like swipe and move) on each ViewHolder,
        and uses callbacks to signal when a user is performing these actions.
        */

        final ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder
                            target) {
                        return false;
                    }
                    //Called when a user swipes left or right on a ViewHolder
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        //Get the index corresponding to the selected position
                        int position = (viewHolder.getAdapterPosition());
                        if (swipeDir == 4) {
                            if (mGeoObjects.get(position).getIsEurope() == true) {
                                Toast.makeText(MainActivity.this, "Correct!!", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(MainActivity.this, "False!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if (swipeDir == 8) {
                            if(mGeoObjects.get(position).getIsEurope() == false) {
                                Toast.makeText(MainActivity.this, "Correct!!", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(MainActivity.this, "False!!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        System.out.println("Swipe direction = " + swipeDir);
                        mGeoObjects.remove(position);
                        mAdapter.notifyItemRemoved(position);
                    }
                };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mGeoRecyclerView);
    }
}
