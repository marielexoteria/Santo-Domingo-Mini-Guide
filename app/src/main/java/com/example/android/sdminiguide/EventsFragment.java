package com.example.android.sdminiguide;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
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
public class EventsFragment extends Fragment {


    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tourist_tips, container, false);

        //Setting the map of sights programmatically
        ImageView mapOfEvents = new ImageView(getActivity());
        mapOfEvents.setImageResource(R.drawable.map_events);
        // This is to preserve the original aspect ratio
        mapOfEvents.setAdjustViewBounds(true);

        //Variable needed to build the footer
        TextView footer = new TextView(getActivity());

        //Creating the ArrayList and using it to display content on sights.xml
        ArrayList<TouristTip> eventsList = new ArrayList<TouristTip>();

        //Populating the ArrayList
        eventsList.add(new TouristTip(R.drawable.bonye_thumbnail, R.string.event1_name,
                R.string.event1_address_text, R.drawable.map_hotels, R.string.event1_description,
                R.string.event1_phone_number, R.string.event1_opening_hours, R.string.event1_website,
                R.drawable.map_restaurants, R.string.event1_coordinates, R.string.event1_address_for_map));

        eventsList.add(new TouristTip(R.drawable.casa_de_teatro_thumbnail, R.string.event2_name,
                R.string.event2_address_text, R.drawable.map_hotels, R.string.event2_description,
                R.string.event2_phone_number, R.string.event2_opening_hours, R.string.event2_website,
                R.drawable.map_restaurants, R.string.event2_coordinates, R.string.event2_address_for_map));

        //Creating an ArrayAdapter and a ListView to recycle the views
        TouristTipAdapter eventsItemsAdapter = new TouristTipAdapter(getActivity(), eventsList);
        ListView eventsListView = (ListView) rootView.findViewById(R.id.tourist_tips_list_view);

        //Populating the ListView
        eventsListView.setAdapter(eventsItemsAdapter);
        //Adding the map as a header
        eventsListView.addHeaderView(mapOfEvents, null, false);
        eventsListView.addFooterView(footer, null, false);


        // *** Beginning of the code that builds the Footer section ***

        /*Variables for the emojis I chose to use
         * Unicodes from http://www.unicode.org/emoji/charts/full-emoji-list.html
         * How to display the flag: https://stackoverflow.com/questions/42234666/get-emoji-flag-by-country-code/42235254
         */
        int unicodeEmojiHeart = 0x2665;
        int flagOffset = 0x1F1E6; //regional indicator symbol letter A
        int asciiOffset = 0x41; //ascii code of uppercase letter A
        /*For some reason leaving these values as is, instead of using the codes for the
         * Dominican flag, works.
         */
        String country = getString(R.string.country_iso_code); //ISO code for Dominican Republic  String country = "DO";

        int firstChar = Character.codePointAt(country, 0) - asciiOffset + flagOffset;
        int secondChar = Character.codePointAt(country, 1) - asciiOffset + flagOffset;

        String emojiHeart = new String(Character.toChars(unicodeEmojiHeart));
        String emojiDominicanFlag = new String(Character.toChars(firstChar))
                + new String(Character.toChars(secondChar));

        /* Code for writing emojis found on
         * https://stackoverflow.com/questions/26893796/how-set-emoji-by-unicode-in-a-textview
         * getString(R.string.footer_part_X) = will return the strings of
         * resource IDs footer_part_1 and footer_part_2 as defined in strings.xml
         */
        footer.setText(getString(R.string.footer_part_1) + emojiHeart
                + getString(R.string.footer_part_2) + emojiDominicanFlag);
        footer.setGravity(Gravity.CENTER);
        footer.setTextColor(Color.BLACK);
        footer.setTextSize(TypedValue.COMPLEX_UNIT_SP,
                getResources().getDimension(R.dimen.footer_size));

        // *** End of the code that builds the Footer section  ***

        return rootView;
    }

}
