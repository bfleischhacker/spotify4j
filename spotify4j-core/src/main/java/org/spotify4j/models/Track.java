package org.spotify4j.models;

import java.util.List;


public class Track extends TrackSimple {
    private ExternalId externalIds;
    /**
     * The album on which the track appears. The album object includes a
     * link in `href` to full information about the album.
     **/
    private AlbumSimple album;
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

    public Track(Boolean isPlayable, List<String> availableMarkets, Boolean explicit, SpotifyId id, String type, TrackLink linkedFrom, SpotifyUri uri, ExternalUrl externalUrls, String previewUrl, int trackNumber, int durationMs, String href, int discNumber, List<ArtistSimple> artists, String name, ExternalId externalIds, AlbumSimple album, int popularity) {
        super(isPlayable, availableMarkets, explicit, id, type, linkedFrom, uri, externalUrls, previewUrl, trackNumber, durationMs, href, discNumber, artists, name);
        this.externalIds = externalIds;
        this.album = album;
        this.popularity = popularity;
    }

    public Track() {
        super();
    }

    public ExternalId getExternalIds() {
        return externalIds;
    }

    public Track withExternalIds(ExternalId externalIds) {
        this.externalIds = externalIds;
        return this;
    }

    public AlbumSimple getAlbum() {
        return album;
    }

    public Track withAlbum(AlbumSimple album) {
        this.album = album;
        return this;
    }

    public int getPopularity() {
        return popularity;
    }

    public Track withPopularity(int popularity) {
        this.popularity = popularity;
        return this;
    }
}
