package com.example.android.sdminiguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourist_tips);

        //Setting the map of sights programmatically
        ImageView mapOfHotels = (ImageView) findViewById(R.id.location_map);

        //CAMBIAR MAPA
        mapOfHotels.setImageResource(R.drawable.map_hotels);

        //Creating the ArrayList and using it to display content on sights.xml
        ArrayList<TouristTip> hotelsList = new ArrayList<TouristTip>();

        //Populating the ArrayList
        hotelsList.add(new TouristTip("1) Hodelpa Nicolás de Ovando",
                "Address: Calle Las Damas", "Hodelpa Nicolás de Ovando", "Hours: 456"));
        hotelsList.add(new TouristTip("2) Casa Naemie",
                "Address: Calle Isabel La Católica #11", "Casa Naemie","Hours: 789"));
        hotelsList.add(new TouristTip("3) Hostal Tierra Plana",
                "Address: Calle Hostos #357", "Hostal Tierra Plana", "Hours: 234"));

        //Creating an ArrayAdapter and a ListView to recycle the views
        TouristTipAdapter hotelsItemsAdapter = new TouristTipAdapter(this, hotelsList);

        ListView hotelsListView = (ListView) findViewById(R.id.tourist_tips_list_view);

        //Populating the ListView
        hotelsListView.setAdapter(hotelsItemsAdapter);

    }
}

