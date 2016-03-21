package org.spotify4j.models;

import java.util.List;


public class Album extends AlbumSimple {
    private List<Copyright> copyrights;
    /**
     * The precision with which `release_date` value is known.
     **/
    private ReleaseDatePrecision releaseDatePrecision;
    /**
     * A list of the genres used to classify the album. If not yet classified,
     * the array is empty.
     **/
    private List<String> genres;
    private ExternalId externalIds;
    /**
     * The tracks of the album.
     **/
    private Page<TrackSimple> tracks;
    private List<ArtistSimple> artists;
    /**
     * The date the album was first released, for example "1981-12-15".
     * Depending on the precision, it might be shown as "1981" or
     * "1981-12".
     **/
    private String releaseDate;
    /**
     * The popularity of the album. The value will be between 0 and 100,
     * with 100 being the most popular. The popularity is calculated from
     * the popularity of the album's individual tracks.
     **/
    private int popularity;

    public enum ReleaseDatePrecision {year, month, day}

    public Album(String href, SpotifyId id, List<String> availableMarkets, AlbumType albumType, ExternalUrl externalUrls, SpotifyUri uri, String type, List<Image> images, String name, List<Copyright> copyrights, ReleaseDatePrecision releaseDatePrecision, List<String> genres, ExternalId externalIds, Page<TrackSimple> tracks, List<ArtistSimple> artists, String releaseDate, int popularity) {
        super(href, id, availableMarkets, albumType, externalUrls, uri, type, images, name);
        this.copyrights = copyrights;
        this.releaseDatePrecision = releaseDatePrecision;
        this.genres = genres;
        this.externalIds = externalIds;
        this.tracks = tracks;
        this.artists = artists;
        this.releaseDate = releaseDate;
        this.popularity = popularity;
    }

    public Album() {
        super();
    }

    public List<Copyright> getCopyrights() {
        return copyrights;
    }

    public Album withCopyrights(List<Copyright> copyrights) {
        this.copyrights = copyrights;
        return this;
    }

    public ReleaseDatePrecision getReleaseDatePrecision() {
        return releaseDatePrecision;
    }

    public Album withReleaseDatePrecision(ReleaseDatePrecision releaseDatePrecision) {
        this.releaseDatePrecision = releaseDatePrecision;
        return this;
    }

    public List<String> getGenres() {
        return genres;
    }

    public Album withGenres(List<String> genres) {
        this.genres = genres;
        return this;
    }

    public ExternalId getExternalIds() {
        return externalIds;
    }

    public Album withExternalIds(ExternalId externalIds) {
        this.externalIds = externalIds;
        return this;
    }

    public Page<TrackSimple> getTracks() {
        return tracks;
    }

    public Album withTracks(Page<TrackSimple> tracks) {
        this.tracks = tracks;
        return this;
    }

    public List<ArtistSimple> getArtists() {
        return artists;
    }

    public Album withArtists(List<ArtistSimple> artists) {
        this.artists = artists;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Album withReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public int getPopularity() {
        return popularity;
    }

    public Album withPopularity(int popularity) {
        this.popularity = popularity;
        return this;
    }
}
