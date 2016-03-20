package org.spotify4j.models;

import java.util.List;


public class Artist extends ArtistSimple {
    private List<Image> images;
    private Followers followers;
    /**
     * The popularity of the artist. The value will be between 0 and 100, with
     * 100 being the most popular. The artist's popularity is calculated from
     * the popularity of all the artist's tracks.
     **/
    private int popularity;
    /**
     * A list of the genres the artist is associated with. If not yet
     * classified, the array is empty.
     **/
    private List<String> genres;

    public Artist(String href, SpotifyUri uri, SpotifyId id, String type, ExternalUrl externalUrls, String name, List<Image> images, Followers followers, int popularity, List<String> genres) {
        super(href, uri, id, type, externalUrls, name);
        this.images = images;
        this.followers = followers;
        this.popularity = popularity;
        this.genres = genres;
    }

    public Artist() {
        super();
    }

    public List<Image> getImages() {
        return images;
    }

    public Artist withImages(List<Image> images) {
        this.images = images;
        return this;
    }

    public Followers getFollowers() {
        return followers;
    }

    public Artist withFollowers(Followers followers) {
        this.followers = followers;
        return this;
    }

    public int getPopularity() {
        return popularity;
    }

    public Artist withPopularity(int popularity) {
        this.popularity = popularity;
        return this;
    }

    public List<String> getGenres() {
        return genres;
    }

    public Artist withGenres(List<String> genres) {
        this.genres = genres;
        return this;
    }
}
