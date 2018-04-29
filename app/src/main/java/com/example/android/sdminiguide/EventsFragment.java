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
public class EventsFragment extends Fragment {


    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tourist_tips, container, false);

        //Setting the map of sights programmatically
        ImageView mapOfEvents = (ImageView) rootView.findViewById(R.id.location_map);

        //CAMBIAR MAPA
        mapOfEvents.setImageResource(R.drawable.map_events);

        //Creating the ArrayList and using it to display content on sights.xml
        ArrayList<TouristTip> eventsList = new ArrayList<TouristTip>();

        //Populating the ArrayList
        eventsList.add(new TouristTip("1) Bonyé",
                "Address: Calle Emiliano Tejera", "Bonyé", "Hours: 123"
        ));

        //Creating an ArrayAdapter and a ListView to recycle the views
        TouristTipAdapter eventsItemsAdapter = new TouristTipAdapter(getActivity(), eventsList);

        ListView eventsListView = (ListView) rootView.findViewById(R.id.tourist_tips_list_view);

        //Populating the ListView
        eventsListView.setAdapter(eventsItemsAdapter);

        return rootView;
    }

}
