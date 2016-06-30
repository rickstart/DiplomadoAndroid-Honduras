package com.mobintum.mapfoursquare.models;

/**
 * Created by Rick on 29/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class Venue {

    private String name;
    private LocationVenue locationVenue;

    public Venue(String name, LocationVenue locationVenue) {
        this.name = name;
        this.locationVenue = locationVenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationVenue getLocationVenue() {
        return locationVenue;
    }

    public void setLocationVenue(LocationVenue locationVenue) {
        this.locationVenue = locationVenue;
    }
}
