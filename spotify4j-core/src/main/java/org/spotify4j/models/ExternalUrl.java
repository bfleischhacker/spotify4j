package org.spotify4j.models;

/**
 * Known external URLs for object
 **/
public class ExternalUrl {
    String spotify;

    public ExternalUrl(String spotify) {
        this.spotify = spotify;
    }

    public ExternalUrl() {
    }

    public String getSpotify() {
        return spotify;
    }

    public ExternalUrl withSpotify(String spotify) {
        this.spotify = spotify;
        return this;
    }
}
