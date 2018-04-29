package com.example.android.sdminiguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourist_tips);

        //Setting the map of sights programmatically
        ImageView mapOfEvents = (ImageView) findViewById(R.id.location_map);

        //CAMBIAR MAPA
        mapOfEvents.setImageResource(R.drawable.map_events);

        //Creating the ArrayList and using it to display content on sights.xml
        ArrayList<TouristTip> eventsList = new ArrayList<TouristTip>();

        //Populating the ArrayList
        eventsList.add(new TouristTip("1) Bonyé",
                "Address: Calle Emiliano Tejera", "Bonyé", "Hours: 123"
                ));

        //Creating an ArrayAdapter and a ListView to recycle the views
        TouristTipAdapter eventsItemsAdapter = new TouristTipAdapter(this, eventsList);

        ListView eventsListView = (ListView) findViewById(R.id.tourist_tips_list_view);

        //Populating the ListView
        eventsListView.setAdapter(eventsItemsAdapter);

    }
}

