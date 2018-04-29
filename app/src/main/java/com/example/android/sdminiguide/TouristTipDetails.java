package com.example.android.sdminiguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class TouristTipDetails extends AppCompatActivity{
    public static final String EXTRA_INFO = "info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourist_tip_details);

        //Enabling UP navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Get the data from previous activity (selected song in the playlist) and display it
        //Help from my mentor: how to get the TextViews to display the correct sound file info
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TouristTip file = getIntent().getExtras().getParcelable(EXTRA_INFO);

            TextView name = (TextView)findViewById(R.id.item_name);
            name.setText(file.getName());

            TextView hours = (TextView)findViewById(R.id.item_description);
            hours.setText(file.getOpeningHours());

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



}
