package com.mobintum.moviesearch.models;

/**
 * Created by Rick on 29/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class Poster {
    private String thumbnail;
    private String profile;
    private String detailed;
    private String original;

    public Poster(String thumbnail, String profile, String detailed, String original) {
        this.thumbnail = thumbnail;
        this.profile = profile;
        this.detailed = detailed;
        this.original = original;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
}
