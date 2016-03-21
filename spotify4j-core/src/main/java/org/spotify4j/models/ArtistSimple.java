package org.spotify4j.models;

public class ArtistSimple {
    private ExternalUrl externalUrls;
    /**
     * A link to the Web API endpoint providing full details of the artist.
     **/
    private String href;
    private SpotifyUri uri;
    /**
     * The object type: "artist"
     **/
    private String type;
    /**
     * The name of the artist.
     **/
    private String name;
    private SpotifyId id;

    public ArtistSimple(ExternalUrl externalUrls, String href, SpotifyUri uri, String type, String name, SpotifyId id) {
        this.externalUrls = externalUrls;
        this.href = href;
        this.uri = uri;
        this.type = type;
        this.name = name;
        this.id = id;
    }

    public ArtistSimple() {
    }

    public ExternalUrl getExternalUrls() {
        return externalUrls;
    }

    public ArtistSimple withExternalUrls(ExternalUrl externalUrls) {
        this.externalUrls = externalUrls;
        return this;
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

    public String getType() {
        return type;
    }

    public ArtistSimple withType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public ArtistSimple withName(String name) {
        this.name = name;
        return this;
    }

    public SpotifyId getId() {
        return id;
    }

    public ArtistSimple withId(SpotifyId id) {
        this.id = id;
        return this;
    }
}
