package com.example.android.sdminiguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TouristGuide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_guide);

        //Initializing variables
        Button sights = (Button) findViewById(R.id.sights);
        Button restaurants = (Button) findViewById(R.id.restaurants);
        Button hotels = (Button) findViewById(R.id.hotels);
        Button events = (Button) findViewById(R.id.events);

        //Open the activities based on which button the user clicked
        sights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sightsActivity = new Intent(getApplicationContext(), SightsActivity.class);
                startActivity(sightsActivity);
            }
        });

        restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restaurantsActivity = new Intent(getApplicationContext(), RestaurantsActivity.class);
                startActivity(restaurantsActivity);
            }
        });

        hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hotelsActivity = new Intent(getApplicationContext(), HotelsActivity.class);
                startActivity(hotelsActivity);
            }
        });

        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eventsActivity = new Intent(getApplicationContext(), EventsActivity.class);
                startActivity(eventsActivity);
            }
        });


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
