package org.spotify4j.models;

public class SavedTrack {
    private Track track;
    /**
     * The date and time the track was saved.
     * <p>
     * Timestamps are returned in [ISO 8601](http://en.wikipedia.org/wiki/ISO_8601)
     * format as [Coordinated Universal Time](http://en.wikipedia.org/wiki/Offset
     * _to_Coordinated_Universal_Time) (UTC) with zero offset.
     * YYYY-MM-DDTHH:MM:SSZ.
     **/
    private String addedAt;

    public SavedTrack(Track track, String addedAt) {
        this.track = track;
        this.addedAt = addedAt;
    }

    public SavedTrack() {
    }

    public Track getTrack() {
        return track;
    }

    public SavedTrack withTrack(Track track) {
        this.track = track;
        return this;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public SavedTrack withAddedAt(String addedAt) {
        this.addedAt = addedAt;
        return this;
    }
}
