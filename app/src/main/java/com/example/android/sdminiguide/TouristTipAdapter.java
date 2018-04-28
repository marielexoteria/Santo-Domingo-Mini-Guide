package com.example.android.sdminiguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TouristTipAdapter extends ArrayAdapter<TouristTip> {
    public TouristTipAdapter(Activity context, ArrayList<TouristTip> TouristTips) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, TouristTips);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.tourist_guide_list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        TouristTip currentTouristTip = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.item_location_name_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        titleTextView.setText(currentTouristTip.getNameOnListItem());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.item_address_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        addressTextView.setText(currentTouristTip.getAddress());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView openingHoursTextView = (TextView) listItemView.findViewById(R.id.item_opening_hours_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        openingHoursTextView.setText(currentTouristTip.getOpeningHours());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
