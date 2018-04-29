package com.example.android.sdminiguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EateriesFragment extends Fragment {


    public EateriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tourist_tips, container, false);

        //Setting the map of tourist_tips programmatically
        ImageView mapOfRestaurants = (ImageView) rootView.findViewById(R.id.location_map);

        //CAMBIAR MAPA
        mapOfRestaurants.setImageResource(R.drawable.map_restaurants);

        //Creating the ArrayList and using it to display content on tourist_tips.xmlps.xml
        ArrayList<TouristTip> restaurantsList = new ArrayList<TouristTip>();

        //Populating the ArrayList
        restaurantsList.add(new TouristTip("1) D'Luis Parrillada",
                "Address: Av. George Washington #25", "D'Luis Parrillada", "Hours: 567"));
        restaurantsList.add(new TouristTip("2) Barra Payán",
                "Address: Av. 30 de marzo #140", "Barra Payán", "Hours: 890"));
        restaurantsList.add(new TouristTip("3) Mesón D'Bari",
                "Address: Calle Hostos #302", "Mesón D'Bari", "Hours: 345"));

        //Creating an ArrayAdapter and a ListView to recycle the views
        TouristTipAdapter restaurantsItemsAdapter = new TouristTipAdapter(getActivity(), restaurantsList);

        ListView restaurantsListView = (ListView) rootView.findViewById(R.id.tourist_tips_list_view);

        //Populating the ListView
        restaurantsListView.setAdapter(restaurantsItemsAdapter);

        return rootView;
    }

}
