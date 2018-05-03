package com.example.android.sdminiguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TouristTipsCategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context xContext;

    /**
     * Create a new {@link TouristTipsCategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fragmentManager is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public TouristTipsCategoryAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        xContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SightsFragment();
        } else if (position == 1) {
            return new EateriesFragment();
        } else if (position == 2) {
            return new HotelsFragment();
        } else {
            return new EventsFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return xContext.getString(R.string.fragment_label_sights);
        } else if (position == 1) {
            return xContext.getString(R.string.fragment_label_eateries);
        } else if (position == 2) {
            return xContext.getString(R.string.fragment_label_hotels);
        } else {
            return xContext.getString(R.string.fragment_label_events);
        }
    }
}