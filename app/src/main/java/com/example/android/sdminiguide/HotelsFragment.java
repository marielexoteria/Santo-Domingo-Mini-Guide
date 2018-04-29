package com.example.android.sdminiguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tourist_tips, container, false);

//Setting the map of sights programmatically
        ImageView mapOfHotels = (ImageView) rootView.findViewById(R.id.location_map);

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
        TouristTipAdapter hotelsItemsAdapter = new TouristTipAdapter(getActivity(), hotelsList);

        ListView hotelsListView = (ListView) rootView.findViewById(R.id.tourist_tips_list_view);

        //Populating the ListView
        hotelsListView.setAdapter(hotelsItemsAdapter);

        return rootView;
    }

}
