package com.example.android.sdminiguide;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TouristTipDetails extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_INFO = "info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourist_tip_details);

        //Enabling UP navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Get the data from previous activity (selected song in the playlist) and display it
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TouristTip file = getIntent().getExtras().getParcelable(EXTRA_INFO);

            ImageView mainPhoto = (ImageView)findViewById(R.id.item_main_photo);
            mainPhoto.setImageResource(file.getMainPhoto());

            TextView name = (TextView)findViewById(R.id.item_name);
            name.setText(file.getName());

            TextView description = (TextView)findViewById(R.id.item_description);
            description.setText(file.getDescription());

            /*TextView practicalInfoLabel = (TextView)findViewById(R.id.item_description);
            practicalInfoLabel.setText(R.string.practical_info_subtitle);*/

            TextView address = (TextView)findViewById(R.id.item_address);
            address.setText(file.getAddress());

            TextView phoneNumber = (TextView)findViewById(R.id.item_phone_number);
            phoneNumber.setText(file.getPhoneNumber());

            TextView openingHours = (TextView)findViewById(R.id.item_opening_hours);
            openingHours.setText(file.getOpeningHours());

            TextView website = (TextView)findViewById(R.id.item_website);
            website.setText(file.getWebsite());

            ImageView mainMapScreenshot = (ImageView)findViewById(R.id.item_map_screenshot);
            mainMapScreenshot.setImageResource(file.getMainPhoto());

            //Trying out opening G Maps with an intent - initializing button view
            Button viewOnMaps = (Button) findViewById(R.id.view_on_maps);
            viewOnMaps.setOnClickListener(this);

        }
    }

    //UP navigation code modified to go to the previous activity (Audiobooks, Podcast or Music). This
    //code alters the visual behavior and shows the NowPlaying activity moving to the right and then
    //the Audiobooks/Podcasts/Music activity shows.
    //Using "NavUtils.navigateUpFromSameTask(this);" does the opposite effect
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

    //This method allows the user to view the sight/restaurant/hotel/event on Google Maps
    //by sending the coordinates of the place
    //PONER LA INFO EN OTRO ARCHIVO SI PUEDO!
    //From https://developers.google.com/maps/documentation/urls/android-intents (intent requests +
    // location search)
    public void onClick(View view) {
        Uri sightAddress = Uri.parse("geo:0,0?q=Mesón D'Bari, Santo+Domingo, Dominican+Republic");
        //The official documentation says that coords are not necessary when passing an address,
        //but just to make sure that the location pin will be at the right place I could do
        //this geo:18.477567,-69.882681?q=Alcázar de Colón, Santo+Domingo, Dominican+Republic
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, sightAddress);
        mapIntent.setPackage("com.google.android.apps.maps");
        //If there's a maps app installed in the user's phone, then start the intent
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }

    }

}
