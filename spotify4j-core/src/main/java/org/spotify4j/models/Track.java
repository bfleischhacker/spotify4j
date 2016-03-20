package org.spotify4j.models;

import java.util.List;


public class Track extends TrackSimple {
    /**
     * The popularity of the track. The value will be between 0 and 100, with
     * 100 being the most popular.
     * <p>
     * The popularity of a track is a value between 0 and 100, with 100 being
     * the most popular. The popularity is calculated by algorithm and is
     * based, in the most part, on the total number of plays the track has
     * had and how recent those plays are.
     * <p>
     * Generally speaking, songs that are being played a lot now will have
     * a higher popularity than songs that were played a lot in the past.
     * Duplicate tracks (e.g. the same track from a single and an album) are
     * rated independently. Artist and album popularity is derived
     * mathematically from track popularity. Note that the popularity value may
     * lag actual popularity by a few days: the value is not updated in
     * real time.
     **/
    private int popularity;
    /**
     * The album on which the track appears. The album object includes a
     * link in `href` to full information about the album.
     **/
    private AlbumSimple album;
    private ExternalId externalIds;

    public Track(String previewUrl, SpotifyUri uri, String href, SpotifyId id, String type, String name, int durationMs, Boolean isPlayable, ExternalUrl externalUrls, Boolean explicit, List<String> availableMarkets, int trackNumber, TrackLink linkedFrom, int discNumber, List<ArtistSimple> artists, int popularity, AlbumSimple album, ExternalId externalIds) {
        super(previewUrl, uri, href, id, type, name, durationMs, isPlayable, externalUrls, explicit, availableMarkets, trackNumber, linkedFrom, discNumber, artists);
        this.popularity = popularity;
        this.album = album;
        this.externalIds = externalIds;
    }

    public Track() {
        super();
    }

    public int getPopularity() {
        return popularity;
    }

    public Track withPopularity(int popularity) {
        this.popularity = popularity;
        return this;
    }

    public AlbumSimple getAlbum() {
        return album;
    }

    public Track withAlbum(AlbumSimple album) {
        this.album = album;
        return this;
    }

    public ExternalId getExternalIds() {
        return externalIds;
    }

    public Track withExternalIds(ExternalId externalIds) {
        this.externalIds = externalIds;
        return this;
    }
}
