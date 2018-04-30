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
    private int xNameOnListItem;

    //The address of the tourist tip
    private int xAddress;

    //The opening hours of the tourist tip
    private int xOpeningHours;

    /* The following items are shown on the detail screens, together with the name and opening hours */

    //The name of the tourist tip
    private int xName;

    //The main photo of the tourist tip
    private int xMainPhoto;

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
    private int xCoordinates;

    //Creating the constructor
    public TouristTip(int thumbnail, int nameOnListItem, int address, int name, int openingHours, int mainPhoto,
                      int description, int phoneNumber, int website, int map,
                      int coordinates) {
        //The variables take the value of the arguments
        xThumbnail = thumbnail;
        xNameOnListItem = nameOnListItem;
        xAddress = address;
        xName = name;
        xOpeningHours = openingHours;
        xDescription = description;
        xMainPhoto = mainPhoto;
        xPhoneNumber = phoneNumber;
        xWebsite = website;
        xMap = map;
        xCoordinates = coordinates;

    }

    //Get the thumbnail of the tourist tip
    public int getThumbnailID() {
        return xThumbnail;
    }

    //Get the name of the tourist tip used in the format "1) Tourist tip"
    public int getNameOnListItem() {
        return xNameOnListItem;
    }

    //Get the address of the tourist tip
    public int getAddress() {
        return xAddress;
    }

    //Get the opening hours of the tourist tip
    public int getOpeningHours() {
        return xOpeningHours;
    }

    //Get the name of the tourist tip
    public int getName() {
        return xName;
    }


    //Get the main photo of the tourist tip
    public int getMainPhoto() {
        return xMainPhoto;
    }

    //Get the description of the tourist tip
    public int getDescription() {
        return xDescription;
    }

    //Get the phone number of the tourist tip
    public int getPhoneNumber() {
        return xPhoneNumber;
    }

    //Get the website of the tourist tip
    public int getWebsite() {
        return xWebsite;
    }

    //Get the screenshot of the map showing the tourist tip
    public int getMap() {
        return xMap;
    }

    //Get the coordinates of the tourist tip
    public int getCoordinates() {
        return xCoordinates;
    }

    //Using the Parcelable interface to read the info about the pertinent file in the
    //position of the ListItem when the user of the app touches a specific file
    //they want to listen to
    protected TouristTip(Parcel in) {
        xMainPhoto = in.readInt();
        xName = in.readInt();
        xDescription = in.readInt();
        xAddress = in.readInt();
        xPhoneNumber = in.readInt();
        xOpeningHours = in.readInt();
        xWebsite = in.readInt();
        xMap = in.readInt();
        xCoordinates = in.readInt();
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
        dest.writeInt(xMainPhoto);
        dest.writeInt(xName);
        dest.writeInt(xDescription);
        dest.writeInt(xAddress);
        dest.writeInt(xPhoneNumber);
        dest.writeInt(xOpeningHours);
        dest.writeInt(xWebsite);
        dest.writeInt(xMap);
        dest.writeInt(xCoordinates);
    }

}
