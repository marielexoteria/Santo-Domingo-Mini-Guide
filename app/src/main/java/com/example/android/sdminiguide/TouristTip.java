package com.example.android.sdminiguide;

/*
 * {@Link TouristTips} represents a tourist tip to show as a sight, a restaurant, a hotel or an event.
 * The info about the tourist tip is split between 2 screens
 * The fragments screen will only list the name of the place, the address and opening hours
 * together with a thumbnail.
 * The full info is shown in the details screen.
 */

import android.os.Parcel;
import android.os.Parcelable;

public class TouristTip implements Parcelable {

    /* The following 3 items are shown on the fragments screen */

    //The thumbnail of the tourist tip
    private int xThumbnail;

    //The name of the tourist tip used in the format "1) Tourist tip"
    //Because it will be shown in a map with a number instead of a location pin
    private String xNameOnListItem;

    //The address of the tourist tip
    private String xAddress;

    //The opening hours of the tourist tip
    private String xOpeningHours;

    /* The following items are shown on the detail screens, together with the name and opening hours */

    //The name of the tourist tip
    private String xName;

    /*//The main photo of the tourist tip
    /*private int xMainPhoto;

    //The description of the tourist tip
    private int xDescription;

    //The phone number of the tourist tip
    private int xPhoneNumber;

    //The website of the tourist tip
    private int xWebsite;

    //The screenshot of the map showing the tourist tip
    private int xMap;

    //The coordinates of the tourist tip, to be used to open the user's Map app to
    //see the location of the tourist tip
    private int xCoordinates;*/

    //Creating the constructor
    public TouristTip(String nameOnListItem, String address, String name, String openingHours) {
        //The variables take the value of the arguments
        //xThumbnail = thumbnail;
        xNameOnListItem = nameOnListItem;
        xAddress = address;
        xName = name;
        xOpeningHours = openingHours;
        /*public TouristTips (int thumbnail, int locationName, int openingHours, int name,
        int mainPhoto, int description, int address, int phoneNumber, int website, int map,
        int coordinates) {
        xName = name;
        xMainPhoto = photo;


        xPhoneNumber = phoneNumber;
        xWebsite = website;
        xMap = map;
        xCoordinates = coordinates;*/

    }

    //Get the thumbnail of the tourist tip
    /*public int getThumbnailID() {
        return xThumbnail;
    }*/

    //Get the name of the tourist tip used in the format "1) Tourist tip"
    public String getNameOnListItem() {
        return xNameOnListItem;
    }

    //Get the address of the tourist tip
    public String getAddress() {
        return xAddress;
    }

    //Get the opening hours of the tourist tip
    public String getOpeningHours() {
        return xOpeningHours;
    }

    //Get the name of the tourist tip
    public String getName() {
        return xName;
    }


    //Get the main photo of the tourist tip
    /*public int getMainPhotoID() {
        return xMainPhoto;
    }


    //Get the description of the tourist tip
    /*public int getDescriptionID() {
        return xDescription;
    }


    //Get the phone number of the tourist tip
    public int getPhoneNumberID() {
        return xPhoneNumber;
    }

    //Get the website of the tourist tip
    public int getWebsiteID() {
        return xWebsite;
    }

    //Get the screenshot of the map showing the tourist tip
    public int getMapID() {
        return xMap;
    }

    //Get the coordinates of the tourist tip
    public int getCoordinatesID() {
        return xCoordinates;
    }*/

    //Using the Parcelable interface to read the info about the pertinent file
    //in the position of the GridItem when the user of the app touches a specific file
    //they want to listen to
    protected TouristTip(Parcel in) {
        xName = in.readString();
        xOpeningHours = in.readString();
    }

    public static final Creator<TouristTip> CREATOR = new Creator<TouristTip>() {
        @Override
        public TouristTip createFromParcel(Parcel in) {
            return new TouristTip(in);
        }

        @Override
        public TouristTip[] newArray(int size) {
            return new TouristTip[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(xName);
        dest.writeString(xOpeningHours);
    }

}
