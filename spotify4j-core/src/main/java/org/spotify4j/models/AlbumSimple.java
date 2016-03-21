package org.spotify4j.models;

import java.util.List;


public class AlbumSimple {
    /**
     * A link to the Web API endpoint providing full details of the album.
     **/
    private String href;
    private SpotifyId id;
    /**
     * The markets in which the album is available: [ISO 3166-1 alpha-2 country
     * codes](http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2). Note that an album
     * is considered available in a market when at least 1 of its tracks is
     * available in that market.
     **/
    private List<String> availableMarkets;
    /**
     * The type of the album: one of "album", "single", or "compilation".
     **/
    private AlbumType albumType;
    private ExternalUrl externalUrls;
    private SpotifyUri uri;
    private String type;
    private List<Image> images;
    /**
     * The name of the album.
     **/
    private String name;

    public enum AlbumType {album, single, compilation}

    public AlbumSimple(String href, SpotifyId id, List<String> availableMarkets, AlbumType albumType, ExternalUrl externalUrls, SpotifyUri uri, String type, List<Image> images, String name) {
        this.href = href;
        this.id = id;
        this.availableMarkets = availableMarkets;
        this.albumType = albumType;
        this.externalUrls = externalUrls;
        this.uri = uri;
        this.type = type;
        this.images = images;
        this.name = name;
    }

    public AlbumSimple() {
    }

    public String getHref() {
        return href;
    }

    public AlbumSimple withHref(String href) {
        this.href = href;
        return this;
    }

    public SpotifyId getId() {
        return id;
    }

    public AlbumSimple withId(SpotifyId id) {
        this.id = id;
        return this;
    }

    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    public AlbumSimple withAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
        return this;
    }

    public AlbumType getAlbumType() {
        return albumType;
    }

    public AlbumSimple withAlbumType(AlbumType albumType) {
        this.albumType = albumType;
        return this;
    }

    public ExternalUrl getExternalUrls() {
        return externalUrls;
    }

    public AlbumSimple withExternalUrls(ExternalUrl externalUrls) {
        this.externalUrls = externalUrls;
        return this;
    }

    public SpotifyUri getUri() {
        return uri;
    }

    public AlbumSimple withUri(SpotifyUri uri) {
        this.uri = uri;
        return this;
    }

    public String getType() {
        return type;
    }

    public AlbumSimple withType(String type) {
        this.type = type;
        return this;
    }

    public List<Image> getImages() {
        return images;
    }

    public AlbumSimple withImages(List<Image> images) {
        this.images = images;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumSimple withName(String name) {
        this.name = name;
        return this;
    }
}
