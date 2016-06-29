package com.mobintum.moviesearch.models;

/**
 * Created by Rick on 29/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class Movie {

    private String title;
    private Integer year;
    private Raiting raiting;
    private String synopsis;
    private Poster poster;

    public Movie(String title, Integer year, Raiting raiting, String synopsis, Poster poster) {
        this.title = title;
        this.year = year;
        this.raiting = raiting;
        this.synopsis = synopsis;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Raiting getRaiting() {
        return raiting;
    }

    public void setRaiting(Raiting raiting) {
        this.raiting = raiting;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Poster getPoster() {
        return poster;
    }

    public void setPoster(Poster poster) {
        this.poster = poster;
    }
}
