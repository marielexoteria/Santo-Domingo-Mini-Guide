package com.example.android.sdminiguide;

/*
 * {@Link TouristTip} represents a tourist tip to show as a sight, a place to eat (eatery), a hotel
 * or an event. The info about the tourist tip is split between 2 screens.
 * The fragments screen will only list the name of the place and the address
 * together with a thumbnail.
 * The full info is shown in the details screen.
 */

import android.os.Parcel;
import android.os.Parcelable;

public class TouristTip implements Parcelable {

    /* The following 3 items are shown on the fragments screen */

    //The thumbnail of the tourist tip
    private int xThumbnail;

    //The name of the tourist tip
    private int xName;

    //The address of the tourist tip
    private int xAddress;

    /* The following items are shown on the details screen, together with xName, xAddress */

    //The main photo of the tourist tip
    private int xMainPhoto;

    //The description of the tourist tip
    private int xDescription;

    //The phone number of the tourist tip
    private int xPhoneNumber;

    //The opening hours of the tourist tip
    private int xOpeningHours;

    //The website of the tourist tip
    private int xWebsite;

    //The screenshot of the map showing the tourist tip
    private int xMap;

    //The coordinates of the tourist tip, to be used to open Google Maps to
    //see the location of the tourist tip
    private int xCoordinates;

    //The address of the tourist tip, to be used to open Google Maps to
    //see the location of the tourist tip
    private int xAddressForMap;

    //Creating the constructor
    public TouristTip(int thumbnail, int name, int address, int mainPhoto, int description,
                       int phoneNumber, int openingHours, int website, int map,
                      int coordinates, int addressForMap) {
        //The variables take the value of the arguments
        xThumbnail = thumbnail;
        xName = name;
        xAddress = address;
        xMainPhoto = mainPhoto;
        xDescription = description;
        xPhoneNumber = phoneNumber;
        xOpeningHours = openingHours;
        xWebsite = website;
        xMap = map;
        xCoordinates = coordinates;
        xAddressForMap = addressForMap;
    }

    //Get the thumbnail of the tourist tip
    public int getThumbnail() {
        return xThumbnail;
    }

    //Get the name of the tourist tip
    public int getName() {
        return xName;
    }

    //Get the address of the tourist tip
    public int getAddress() {
        return xAddress;
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

    //Get the opening hours of the tourist tip
    public int getOpeningHours() {
        return xOpeningHours;
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

    //Get the address of the tourist tip to show on Google Maps
    public int getAddressForMap() {
        return xAddressForMap;
    }

    //Using the Parcelable interface to read the info about the tourist tip in the
    //position of the ListItem when the user of the app wants to read more about a
    //specific tourist tip
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
        xAddressForMap = in.readInt();
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
        dest.writeInt(xAddressForMap);
    }

}
