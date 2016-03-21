package org.spotify4j.models;

import java.util.List;


public class Artist extends ArtistSimple {
    /**
     * A list of the genres the artist is associated with. If not yet
     * classified, the array is empty.
     **/
    private List<String> genres;
    private Followers followers;
    private List<Image> images;
    /**
     * The popularity of the artist. The value will be between 0 and 100, with
     * 100 being the most popular. The artist's popularity is calculated from
     * the popularity of all the artist's tracks.
     **/
    private int popularity;

    public Artist(ExternalUrl externalUrls, String href, SpotifyUri uri, String type, String name, SpotifyId id, List<String> genres, Followers followers, List<Image> images, int popularity) {
        super(externalUrls, href, uri, type, name, id);
        this.genres = genres;
        this.followers = followers;
        this.images = images;
        this.popularity = popularity;
    }

    public Artist() {
        super();
    }

    public List<String> getGenres() {
        return genres;
    }

    public Artist withGenres(List<String> genres) {
        this.genres = genres;
        return this;
    }

    public Followers getFollowers() {
        return followers;
    }

    public Artist withFollowers(Followers followers) {
        this.followers = followers;
        return this;
    }

    public List<Image> getImages() {
        return images;
    }

    public Artist withImages(List<Image> images) {
        this.images = images;
        return this;
    }

    public int getPopularity() {
        return popularity;
    }

    public Artist withPopularity(int popularity) {
        this.popularity = popularity;
        return this;
    }
}
