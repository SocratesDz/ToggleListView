package com.example.socratesdiaz.togglelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    ArrayList<DataObject> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        if(expListView != null)
            expListView.setGroupIndicator(null);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listData);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /** Saving the current state of the activity
    * for configuration changes [ Portrait <=> Landscape ]
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listData = new ArrayList<DataObject>();

        DataObject top250 = new DataObject("Top 250", "top250", new ArrayList<DataObject>());
        DataObject nowShowing = new DataObject("Now Showing", "now_showing", new ArrayList<DataObject>());
        DataObject comingSoon = new DataObject("Coming soon...", "coming_soon", new ArrayList<DataObject>());

        DataObject[] top250Array = new DataObject[]{
                new DataObject("The Shawshank Redemption", "top250_1", new ArrayList<DataObject>()),
                new DataObject("The Godfather", "top250_2", new ArrayList<DataObject>()),
                new DataObject("The Godfather: Part II", "top250_3", new ArrayList<DataObject>()),
                new DataObject("Pulp Fiction", "top250_4", new ArrayList<DataObject>()),
                new DataObject("The Good, the Bad and the Ugly", "top250_5", new ArrayList<DataObject>())
        };

        top250.setChildren(new ArrayList<DataObject>(Arrays.asList(top250Array)));

        DataObject[] nowShowingArray = new DataObject[]{
                new DataObject("The Conjuring", "nowShowing_1", new ArrayList<DataObject>()),
                new DataObject("Despicable Me 2", "nowShowing_2", new ArrayList<DataObject>()),
                new DataObject("Turbo", "nowShowing_3", new ArrayList<DataObject>()),
                new DataObject("Grown Ups 2", "nowShowing_4", new ArrayList<DataObject>()),
                new DataObject("Red 2", "nowShowing_5", new ArrayList<DataObject>()),
                new DataObject("The Wolverine", "nowShowing_6", new ArrayList<DataObject>())
        };

        nowShowing.setChildren(new ArrayList<DataObject>(Arrays.asList(nowShowingArray)));

        DataObject[] comingSoonArray = new DataObject[] {
                new DataObject("2 Guns", "comingSoon_1", new ArrayList<DataObject>()),
                new DataObject("The Smurfs 2", "comingSoon_2", new ArrayList<DataObject>()),
                new DataObject("The Spectacular Now", "comingSoon_3", new ArrayList<DataObject>()),
                new DataObject("The Canyons", "comingSoon_4", new ArrayList<DataObject>()),
                new DataObject("Europa Report", "comingSoon_5", new ArrayList<DataObject>())
        };

        comingSoon.setChildren(new ArrayList<DataObject>(Arrays.asList(comingSoonArray)));

        listData.add(top250);
        listData.add(nowShowing);
        listData.add(comingSoon);
        listData.add(new DataObject("Banned Movies", "banned", new ArrayList<DataObject>()));
        listData.add(new DataObject("Old Movies", "old", new ArrayList<DataObject>()));
    }
}
