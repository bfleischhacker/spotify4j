package org.spotify4j.models;

import java.util.List;


public class Album extends AlbumSimple {
    /**
     * The popularity of the album. The value will be between 0 and 100,
     * with 100 being the most popular. The popularity is calculated from
     * the popularity of the album's individual tracks.
     **/
    private int popularity;
    private List<Copyright> copyrights;
    private List<ArtistSimple> artists;
    private ExternalId externalIds;
    /**
     * The date the album was first released, for example "1981-12-15".
     * Depending on the precision, it might be shown as "1981" or
     * "1981-12".
     **/
    private String releaseDate;
    /**
     * A list of the genres used to classify the album. If not yet classified,
     * the array is empty.
     **/
    private List<String> genres;
    /**
     * The tracks of the album.
     **/
    private Page<TrackSimple> tracks;
    /**
     * The precision with which `release_date` value is known.
     **/
    private ReleaseDatePrecision releaseDatePrecision;

    public enum ReleaseDatePrecision {year, month, day}

    public Album(String type, List<Image> images, ExternalUrl externalUrls, String href, SpotifyId id, SpotifyUri uri, AlbumType albumType, List<String> availableMarkets, String name, int popularity, List<Copyright> copyrights, List<ArtistSimple> artists, ExternalId externalIds, String releaseDate, List<String> genres, Page<TrackSimple> tracks, ReleaseDatePrecision releaseDatePrecision) {
        super(type, images, externalUrls, href, id, uri, albumType, availableMarkets, name);
        this.popularity = popularity;
        this.copyrights = copyrights;
        this.artists = artists;
        this.externalIds = externalIds;
        this.releaseDate = releaseDate;
        this.genres = genres;
        this.tracks = tracks;
        this.releaseDatePrecision = releaseDatePrecision;
    }

    public Album() {
        super();
    }

    public int getPopularity() {
        return popularity;
    }

    public Album withPopularity(int popularity) {
        this.popularity = popularity;
        return this;
    }

    public List<Copyright> getCopyrights() {
        return copyrights;
    }

    public Album withCopyrights(List<Copyright> copyrights) {
        this.copyrights = copyrights;
        return this;
    }

    public List<ArtistSimple> getArtists() {
        return artists;
    }

    public Album withArtists(List<ArtistSimple> artists) {
        this.artists = artists;
        return this;
    }

    public ExternalId getExternalIds() {
        return externalIds;
    }

    public Album withExternalIds(ExternalId externalIds) {
        this.externalIds = externalIds;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Album withReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public List<String> getGenres() {
        return genres;
    }

    public Album withGenres(List<String> genres) {
        this.genres = genres;
        return this;
    }

    public Page<TrackSimple> getTracks() {
        return tracks;
    }

    public Album withTracks(Page<TrackSimple> tracks) {
        this.tracks = tracks;
        return this;
    }

    public ReleaseDatePrecision getReleaseDatePrecision() {
        return releaseDatePrecision;
    }

    public Album withReleaseDatePrecision(ReleaseDatePrecision releaseDatePrecision) {
        this.releaseDatePrecision = releaseDatePrecision;
        return this;
    }
}
