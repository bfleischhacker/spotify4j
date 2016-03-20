package org.spotify4j.models;

import java.util.List;


public class TrackSimple {
    /**
     * A URL to a 30 second preview (MP3 format) of the track.
     **/
    private String previewUrl;
    private SpotifyUri uri;
    /**
     * A link to the Web API endpoint providing full details of the track.
     **/
    private String href;
    private SpotifyId id;
    /**
     * The object type: "track".
     **/
    private String type;
    /**
     * The name of the track.
     **/
    private String name;
    /**
     * The track length in milliseconds.
     **/
    private int durationMs;
    /**
     * Part of the response when [Track Relinking](https://developer.spotify.
     * com/web-api/track-relinking-guide/) is applied. If `true`, the track is
     * playable in the given market. Otherwise `false`.
     **/
    private Boolean isPlayable;
    private ExternalUrl externalUrls;
    /**
     * Whether or not the track has explicit lyrics (`true` = yes it does;
     * `false` = no it does not OR unknown).
     **/
    private Boolean explicit;
    /**
     * A list of the countries in which the track can be played, identified by
     * their [ISO 3166-1 alpha-2](http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2)
     * code.
     **/
    private List<String> availableMarkets;
    /**
     * The number of the track. If an album has several discs, the track
     * number is the number on the specified disc.
     **/
    private int trackNumber;
    /**
     * Part of the response when [Track Relinking](https://developer.spotify.
     * com/web-api/track-relinking-guide/) is applied and is only part of the
     * response if the track linking, in fact, exists. The requested track
     * has been replaced with a different track. The track in the `linked_from`
     * object contains information about the originally requested track.
     **/
    private TrackLink linkedFrom;
    /**
     * The disc number (usually `1` unless the album consists of more than
     * one disc).
     **/
    private int discNumber;
    private List<ArtistSimple> artists;

    public TrackSimple(String previewUrl, SpotifyUri uri, String href, SpotifyId id, String type, String name, int durationMs, Boolean isPlayable, ExternalUrl externalUrls, Boolean explicit, List<String> availableMarkets, int trackNumber, TrackLink linkedFrom, int discNumber, List<ArtistSimple> artists) {
        this.previewUrl = previewUrl;
        this.uri = uri;
        this.href = href;
        this.id = id;
        this.type = type;
        this.name = name;
        this.durationMs = durationMs;
        this.isPlayable = isPlayable;
        this.externalUrls = externalUrls;
        this.explicit = explicit;
        this.availableMarkets = availableMarkets;
        this.trackNumber = trackNumber;
        this.linkedFrom = linkedFrom;
        this.discNumber = discNumber;
        this.artists = artists;
    }

    public TrackSimple() {
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public TrackSimple withPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
        return this;
    }

    public SpotifyUri getUri() {
        return uri;
    }

    public TrackSimple withUri(SpotifyUri uri) {
        this.uri = uri;
        return this;
    }

    public String getHref() {
        return href;
    }

    public TrackSimple withHref(String href) {
        this.href = href;
        return this;
    }

    public SpotifyId getId() {
        return id;
    }

    public TrackSimple withId(SpotifyId id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public TrackSimple withType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public TrackSimple withName(String name) {
        this.name = name;
        return this;
    }

    public int getDurationMs() {
        return durationMs;
    }

    public TrackSimple withDurationMs(int durationMs) {
        this.durationMs = durationMs;
        return this;
    }

    public Boolean getIsPlayable() {
        return isPlayable;
    }

    public TrackSimple withIsPlayable(Boolean isPlayable) {
        this.isPlayable = isPlayable;
        return this;
    }

    public ExternalUrl getExternalUrls() {
        return externalUrls;
    }

    public TrackSimple withExternalUrls(ExternalUrl externalUrls) {
        this.externalUrls = externalUrls;
        return this;
    }

    public Boolean getExplicit() {
        return explicit;
    }

    public TrackSimple withExplicit(Boolean explicit) {
        this.explicit = explicit;
        return this;
    }

    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    public TrackSimple withAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
        return this;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public TrackSimple withTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
        return this;
    }

    public TrackLink getLinkedFrom() {
        return linkedFrom;
    }

    public TrackSimple withLinkedFrom(TrackLink linkedFrom) {
        this.linkedFrom = linkedFrom;
        return this;
    }

    public int getDiscNumber() {
        return discNumber;
    }

    public TrackSimple withDiscNumber(int discNumber) {
        this.discNumber = discNumber;
        return this;
    }

    public List<ArtistSimple> getArtists() {
        return artists;
    }

    public TrackSimple withArtists(List<ArtistSimple> artists) {
        this.artists = artists;
        return this;
    }
}
