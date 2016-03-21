package org.spotify4j.models;

public class PlaylistTrack {
    private UserPublic addedBy;
    /**
     * Whether this track is a [local file](https://developer.spotify.com/
     * web-api/local-files-spotify-playlists/) or not.
     **/
    private Boolean isLocal;
    /**
     * The date and time the track was saved.
     * <p>
     * Timestamps are returned in [ISO 8601](http://en.wikipedia.org/wiki/ISO_8601)
     * format as [Coordinated Universal Time](http://en.wikipedia.org/wiki/
     * Offset_to_Coordinated_Universal_Time) (UTC) with zero offset.
     * YYYY-MM-DDTHH:MM:SSZ.
     **/
    private String addedAt;
    /**
     * Information about the track.
     **/
    private Track track;

    public PlaylistTrack(UserPublic addedBy, Boolean isLocal, String addedAt, Track track) {
        this.addedBy = addedBy;
        this.isLocal = isLocal;
        this.addedAt = addedAt;
        this.track = track;
    }

    public PlaylistTrack() {
    }

    public UserPublic getAddedBy() {
        return addedBy;
    }

    public PlaylistTrack withAddedBy(UserPublic addedBy) {
        this.addedBy = addedBy;
        return this;
    }

    public Boolean getIsLocal() {
        return isLocal;
    }

    public PlaylistTrack withIsLocal(Boolean isLocal) {
        this.isLocal = isLocal;
        return this;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public PlaylistTrack withAddedAt(String addedAt) {
        this.addedAt = addedAt;
        return this;
    }

    public Track getTrack() {
        return track;
    }

    public PlaylistTrack withTrack(Track track) {
        this.track = track;
        return this;
    }
}
