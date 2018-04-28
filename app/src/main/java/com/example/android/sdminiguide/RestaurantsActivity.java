package com.example.android.sdminiguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourist_tips);

        //Setting the map of tourist_tips programmatically
        ImageView mapOfRestaurants = (ImageView) findViewById(R.id.location_map);

        //CAMBIAR MAPA
        mapOfRestaurants.setImageResource(R.drawable.map_restaurants);

        //Creating the ArrayList and using it to display content on tourist_tips.xmlps.xml
        ArrayList<TouristTip> restaurantsList = new ArrayList<TouristTip>();

        //Populating the ArrayList
        restaurantsList.add(new TouristTip("1) D'Luis Parrillada",
                "Av. George Washington #25 (Paseo Pte. Billini)",
                "Every day 8:00 am to 1:00 am"));
        restaurantsList.add(new TouristTip("2) Barra Payán",
                "Av. 30 de marzo #140",
                "24-hour service"));
        restaurantsList.add(new TouristTip("3) Mesón D'Bari",
                "Calle Hostos #302",
                "Every day 12:00 pm to 12:00 am"));

        //Creating an ArrayAdapter and a ListView to recycle the views
        TouristTipAdapter restaurantsItemsAdapter = new TouristTipAdapter(this, restaurantsList);

        ListView restaurantsListView = (ListView) findViewById(R.id.tourist_tips_list_view);

        //Populating the ListView
        restaurantsListView.setAdapter(restaurantsItemsAdapter);

    }
}
