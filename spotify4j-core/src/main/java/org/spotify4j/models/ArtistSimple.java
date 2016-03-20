package org.spotify4j.models;

public class ArtistSimple {
    /**
     * A link to the Web API endpoint providing full details of the artist.
     **/
    private String href;
    private SpotifyUri uri;
    private SpotifyId id;
    /**
     * The object type: "artist"
     **/
    private String type;
    private ExternalUrl externalUrls;
    /**
     * The name of the artist.
     **/
    private String name;

    public ArtistSimple(String href, SpotifyUri uri, SpotifyId id, String type, ExternalUrl externalUrls, String name) {
        this.href = href;
        this.uri = uri;
        this.id = id;
        this.type = type;
        this.externalUrls = externalUrls;
        this.name = name;
    }

    public ArtistSimple() {
    }

    public String getHref() {
        return href;
    }

    public ArtistSimple withHref(String href) {
        this.href = href;
        return this;
    }

    public SpotifyUri getUri() {
        return uri;
    }

    public ArtistSimple withUri(SpotifyUri uri) {
        this.uri = uri;
        return this;
    }

    public SpotifyId getId() {
        return id;
    }

    public ArtistSimple withId(SpotifyId id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public ArtistSimple withType(String type) {
        this.type = type;
        return this;
    }

    public ExternalUrl getExternalUrls() {
        return externalUrls;
    }

    public ArtistSimple withExternalUrls(ExternalUrl externalUrls) {
        this.externalUrls = externalUrls;
        return this;
    }

    public String getName() {
        return name;
    }

    public ArtistSimple withName(String name) {
        this.name = name;
        return this;
    }
}
