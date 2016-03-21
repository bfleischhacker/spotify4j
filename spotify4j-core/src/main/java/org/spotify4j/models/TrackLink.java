package org.spotify4j.models;

public class TrackLink {
    /**
     * Known external URLs for this track.
     **/
    private ExternalUrl externalUrls;
    private SpotifyId id;
    private SpotifyUri uri;
    /**
     * A link to the Web API endpoint providing full details of the track.
     **/
    private String href;
    /**
     * The object type: "track".
     **/
    private String type;

    public TrackLink(ExternalUrl externalUrls, SpotifyId id, SpotifyUri uri, String href, String type) {
        this.externalUrls = externalUrls;
        this.id = id;
        this.uri = uri;
        this.href = href;
        this.type = type;
    }

    public TrackLink() {
    }

    public ExternalUrl getExternalUrls() {
        return externalUrls;
    }

    public TrackLink withExternalUrls(ExternalUrl externalUrls) {
        this.externalUrls = externalUrls;
        return this;
    }

    public SpotifyId getId() {
        return id;
    }

    public TrackLink withId(SpotifyId id) {
        this.id = id;
        return this;
    }

    public SpotifyUri getUri() {
        return uri;
    }

    public TrackLink withUri(SpotifyUri uri) {
        this.uri = uri;
        return this;
    }

    public String getHref() {
        return href;
    }

    public TrackLink withHref(String href) {
        this.href = href;
        return this;
    }

    public String getType() {
        return type;
    }

    public TrackLink withType(String type) {
        this.type = type;
        return this;
    }
}
