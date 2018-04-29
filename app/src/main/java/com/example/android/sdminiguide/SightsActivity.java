package com.example.android.sdminiguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SightsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourist_tips);

        //Setting the map of tourist_tips programmatically
        ImageView mapOfSights = (ImageView) findViewById(R.id.location_map);
        mapOfSights.setImageResource(R.drawable.map_sights);

        //Creating the ArrayList and using it to display content on tourist_tips.xmlps.xml
        ArrayList<TouristTip> sightsList = new ArrayList<TouristTip>();

        //Populating the ArrayList
        sightsList.add(new TouristTip("1) Alcázar de Colón",
                "Address: Plaza de España, Calle Las Damas", "Alcázar de Colón", "Hours: 345"));
        sightsList.add(new TouristTip("2) Monasterio de San Francisco",
                "Address: Calle Juan Isidro Pérez", "Monasterio de San Francisco", "Hours: 678"));
        sightsList.add(new TouristTip("3) Catedral Primada de América",
                "Address: Calle Isabel La Católica", "Catedral Primada de América", "Hours: 901"));
        sightsList.add(new TouristTip("4) Larimar Museum",
                "Address: Calle Isabel La Católica #54", "Larimar Museum", "Hours: 456"));
        sightsList.add(new TouristTip("5) Fortaleza Ozama",
                "Address: Calle Las Damas #1", "Fortaleza Ozama", "Hours: 746"));

        //Creating an ArrayAdapter and a ListView to recycle the views
        TouristTipAdapter sightsItemsAdapter = new TouristTipAdapter(this, sightsList);

        ListView sightsListView = (ListView) findViewById(R.id.tourist_tips_list_view);

        //Populating the ListView
        sightsListView.setAdapter(sightsItemsAdapter);



        // *** Beginning of Footer section ***

        //Variables needed to build the footer section of the app
        TextView footer = (TextView) findViewById(R.id.footer);

        /*Variables for the emojis I chose to use
         * Unicodes from http://www.unicode.org/emoji/charts/full-emoji-list.html
         */
        int unicodeEmojiHeart = 0x2665;
        int unicodeEmojiCake = 0x1F370;

        /* Code for writing emojis found on
         * https://stackoverflow.com/questions/26893796/how-set-emoji-by-unicode-in-a-textview
         * getString(R.string.footer_part_X) = will return the strings of
         * resource IDs footer_part_1 and footer_part_2 as defined in strings.xml
         */
        footer.setText(getString(R.string.footer_part_1) + getEmojiByUnicode(unicodeEmojiHeart)
                + getString(R.string.footer_part_2) + getEmojiByUnicode(unicodeEmojiCake));

        // *** End of Footer section ***
    }

    /*
     * Function that returns an emoji as a string to display it in the footer
     * without needing to use a Drawable resource (found on the link above)
     * @param unicode     the int code of the emoji defined in the variables unicodeEmojiHeart
     * & unicodeEmojiCake
     */

    private String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }
}
