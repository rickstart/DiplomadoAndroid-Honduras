package com.mobintum.moviesearch.models;

/**
 * Created by Rick on 29/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class Raiting {
    private Integer criticScore;
    private Integer audienceScore;

    public Raiting(Integer criticScore, Integer audienceScore) {
        this.criticScore = criticScore;
        this.audienceScore = audienceScore;
    }

    public Integer getCriticScore() {
        return criticScore;
    }

    public void setCriticScore(Integer criticScore) {
        this.criticScore = criticScore;
    }

    public Integer getAudienceScore() {
        return audienceScore;
    }

    public void setAudienceScore(Integer audienceScore) {
        this.audienceScore = audienceScore;
    }
}
