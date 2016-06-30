package com.mobintum.mapfoursquare.models;

/**
 * Created by Rick on 29/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class LocationVenue {
    private Double latitude;
    private Double longitude;

    public LocationVenue(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
