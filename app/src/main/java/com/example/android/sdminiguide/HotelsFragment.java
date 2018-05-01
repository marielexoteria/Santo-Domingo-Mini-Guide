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
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tourist_tips, container, false);

        //Setting the map of sights programmatically
        ImageView mapOfHotels = new ImageView(getActivity());
        mapOfHotels.setImageResource(R.drawable.map_hotels);
        // This is to preserve the original aspect ratio
        mapOfHotels.setAdjustViewBounds(true);

        //Variable needed to build the footer
        TextView footer = new TextView(getActivity());

        //Creating the ArrayList and using it to display content on sights.xml
        ArrayList<TouristTip> hotelsList = new ArrayList<TouristTip>();

        //Populating the ArrayList
        hotelsList.add(new TouristTip(R.drawable.hodelpa_thumbnail, R.string.hotel1_name,
                R.string.hotel1_address_text, R.drawable.map_hotels, R.string.hotel1_description,
                R.string.hotel1_phone_number, R.string.hotel1_opening_hours, R.string.hotel1_website,
                R.drawable.map_restaurants, R.string.hotel1_coordinates, R.string.hotel1_address_for_map));

        hotelsList.add(new TouristTip(R.drawable.naemie_thumbnail, R.string.hotel2_name,
                R.string.hotel2_address_text, R.drawable.map_hotels, R.string.hotel2_description,
                R.string.hotel2_phone_number, R.string.hotel2_opening_hours, R.string.hotel2_website,
                R.drawable.map_restaurants, R.string.hotel2_coordinates, R.string.hotel2_address_for_map));

        hotelsList.add(new TouristTip(R.drawable.tierra_plana_thumbnail, R.string.hotel3_name,
                R.string.hotel3_address_text, R.drawable.map_hotels, R.string.hotel3_description,
                R.string.hotel3_phone_number, R.string.hotel3_opening_hours, R.string.hotel3_website,
                R.drawable.map_restaurants, R.string.hotel3_coordinates, R.string.hotel3_address_for_map));

        hotelsList.add(new TouristTip(R.drawable.beaterio_thumbnail, R.string.hotel4_name,
                R.string.hotel4_address_text, R.drawable.beaterio, R.string.hotel4_description,
                R.string.hotel4_phone_number, R.string.hotel4_opening_hours, R.string.hotel4_website,
                R.drawable.map_restaurants, R.string.hotel4_coordinates, R.string.hotel4_address_for_map));

        hotelsList.add(new TouristTip(R.drawable.bettyes_thumbnail, R.string.hotel5_name,
                R.string.hotel5_address_text, R.drawable.map_hotels, R.string.hotel5_description,
                R.string.hotel5_phone_number, R.string.hotel5_opening_hours, R.string.hotel5_website,
                R.drawable.map_restaurants, R.string.hotel5_coordinates, R.string.hotel5_address_for_map));

        //Creating an ArrayAdapter and a ListView to recycle the views
        TouristTipAdapter hotelsItemsAdapter = new TouristTipAdapter(getActivity(), hotelsList);
        ListView hotelsListView = (ListView) rootView.findViewById(R.id.tourist_tips_list_view);

        //Populating the ListView
        hotelsListView.setAdapter(hotelsItemsAdapter);
        //Adding the map as a header
        hotelsListView.addHeaderView(mapOfHotels, null, false);
        hotelsListView.addFooterView(footer, null, false);


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
