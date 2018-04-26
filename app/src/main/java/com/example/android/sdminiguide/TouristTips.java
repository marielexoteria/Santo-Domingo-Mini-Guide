package com.example.android.sdminiguide;

public class TouristTips {

    /* The following 3 items are shown on the fragments screen */

    //The thumbnail of the tourist tip
    private int xThumbnail;

    //The name of the tourist tip
    private int xName;

    //The opening hours of the tourist tip
    private int xOpeningHours;

    /* The following items are shown on the detail screens, together with the name and opening hours */

    //The main photo of the tourist tip
    private int xPhoto;

    //The description of the tourist tip
    private int xDescription;

    //The address of the tourist tip
    private int xAddress;

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
    public TouristTips (int thumbnail, int name, int openingHours, int photo, int description, int address,
        int phoneNumber, int website, int map, int coordinates) {
        //The variables take the value of the arguments
        xThumbnail = thumbnail;
        xName = name;
        xOpeningHours = openingHours;
        xPhoto = photo;
        xDescription = description;
        xAddress = address;
        xPhoneNumber = phoneNumber;
        xWebsite = website;
        xMap = map;
        xCoordinates = coordinates;

    }

    //Get the thumbnail of the tourist tip
    public int getThumbnailID() {
        return xThumbnail;
    }

    //Get the name of the tourist tip
    public int getNameID() {
        return xName;
    }

    //Get the opening hours of the tourist tip
    public int getOpeningHoursID() {
        return xOpeningHours;
    }

    //Get the main photo of the tourist tip
    public int getPhotoID() {
        return xPhoto;
    }

    //Get the description of the tourist tip
    public int getDescriptionID() {
        return xDescription;
    }

    //Get the address of the tourist tip
    public int getAddressID() {
        return xAddress;
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
    }

}
