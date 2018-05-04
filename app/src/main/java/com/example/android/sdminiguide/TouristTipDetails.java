package com.example.android.sdminiguide;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TouristTipDetails extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_INFO = "info";
    //Variable needed to send the coordinates + address to Google Maps
    String uriAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourist_tip_details);

        //Enabling UP navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //To open Google Maps with an intent - initializing button view
        Button viewOnMaps = (Button) findViewById(R.id.view_on_maps);
        viewOnMaps.setOnClickListener(this);

        //Variable needed to build the footer
        TextView footer = (TextView) findViewById(R.id.footer);

        //Get the data from previous activity (selected tourist tip) and display it
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TouristTip file = getIntent().getExtras().getParcelable(EXTRA_INFO);

            ImageView mainPhoto = (ImageView)findViewById(R.id.item_main_photo);
            mainPhoto.setImageResource(file.getMainPhoto());

            TextView name = (TextView)findViewById(R.id.item_name);
            name.setText(file.getName());

            TextView description = (TextView)findViewById(R.id.item_description);
            description.setText(file.getDescription());

            TextView address = (TextView)findViewById(R.id.item_address);
            address.setText(file.getAddress());

            TextView phoneNumber = (TextView)findViewById(R.id.item_phone_number);
            phoneNumber.setText(file.getPhoneNumber());
            //Making this TextView a link without underline as long as the phone number isn't "N/A"
            /* Getting the content of the entry "phone number" to check if it's "N/A" or a valid
            phone number that the user can call to */
            String phoneNumberContent = phoneNumber.getText().toString();
            if (!phoneNumberContent.equals("N/A")) {
                Linkify.addLinks(phoneNumber, Linkify.PHONE_NUMBERS);
                stripUnderlines(phoneNumber);
                //Making the link clickable after removing the underline
                phoneNumber.setMovementMethod(LinkMovementMethod.getInstance());
                //Change the color to the color accent
                phoneNumber.setTextColor(getResources().getColor(R.color.colorAccent));
            }

            TextView openingHours = (TextView)findViewById(R.id.item_opening_hours);
            openingHours.setText(file.getOpeningHours());

            TextView website = (TextView)findViewById(R.id.item_website);
            website.setText(file.getWebsite());
            //Making this TextView a link without underline
            Linkify.addLinks(website, Linkify.WEB_URLS);
            stripUnderlines(website);
            //Making the link clickable after removing the underline
            website.setMovementMethod(LinkMovementMethod.getInstance());

            ImageView mainMapScreenshot = (ImageView)findViewById(R.id.item_map_screenshot);
            mainMapScreenshot.setImageResource(file.getMap());

            uriAddress = "geo:" + getString(file.getCoordinates()) +
                    "?q=" + getString(file.getAddressForMap());
        }

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

        // *** End of the code that builds the Footer section  ***
    }

    //UP navigation code modified to go to the previous activity (fragments screen).
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //This method allows the user to view the sight/eatery/hotel/event on Google Maps
    //by sending the coordinates of the place
    //From https://developers.google.com/maps/documentation/urls/android-intents (intent requests +
    //location search)
    public void onClick(View view) {
        Uri addressForGoogleMaps = Uri.parse(uriAddress);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, addressForGoogleMaps);
        mapIntent.setPackage("com.google.android.apps.maps");

        //If Google Maps installed in the user's phone, then start the intent
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }

    }

    //method to remove underlines from:
    // https://stackoverflow.com/questions/4096851/remove-underline-from-links-in-textview-android
    private void stripUnderlines(TextView textView) {
        Spannable s = new SpannableString(textView.getText());
        URLSpan[] spans = s.getSpans(0, s.length(), URLSpan.class);
        for (URLSpan span: spans) {
            int start = s.getSpanStart(span);
            int end = s.getSpanEnd(span);
            s.removeSpan(span);
            span = new URLSpanNoUnderline(span.getURL());
            s.setSpan(span, start, end, 0);
        }
        textView.setText(s);
    }

    // a customized version of URLSpan which doesn't enable the TextPaint's "underline" property
    private class URLSpanNoUnderline extends URLSpan {
        public URLSpanNoUnderline(String url) {
            super(url);
        }
        @Override public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
        }
    }
}
