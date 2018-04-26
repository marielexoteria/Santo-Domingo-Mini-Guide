package com.example.android.sdminiguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TouristGuide extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_guide);

        //Temp text
        TextView contentGoesHere = (TextView) findViewById(R.id.content_goes_here);
        contentGoesHere.setText("Content coming soon!");

        //Trying out opening G Maps with an intent - initializing button view
        Button viewOnMaps = (Button) findViewById(R.id.view_on_maps);
        viewOnMaps.setOnClickListener(this);

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

    //Trying out opening G Maps with an intent
    //PONER LA INFO EN OTRO ARCHIVO SI PUEDO!
    //From https://developers.google.com/maps/documentation/urls/android-intents (intent requests +
    // location search)
    public void onClick(View view) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=Alcázar de Colón, Santo+Domingo, Dominican+Republic");
        //The official documentation says that coords are not necessary when passing an address,
        //but just to make sure that the location pin will be at the right place I could do
        //this geo:18.477567,-69.882681?q=Alcázar de Colón, Santo+Domingo, Dominican+Republic
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }


    }

    /*
     * Function that returns an emoji as a string to display it in the footer
     * without needing to use a Drawable resource
     * @param unicode     the int code of the emoji defined in the variables unicodeEmojiHeart
     * & unicodeEmojiCake
     */

    private String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

}
