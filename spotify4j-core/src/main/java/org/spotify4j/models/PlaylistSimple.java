package org.spotify4j.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class PlaylistSimple {
    /**
     * A link to the Web API endpoint providing full details of the playlist.
     **/
    private String href;
    /**
     * `true` if the owner allows other users to modify the playlist.
     **/
    private Boolean collaborative;
    /**
     * The version identifier for the current playlist. Can be supplied in
     * other requests to target a specific playlist version: see [Remove
     * tracks from a playlist](https://developer.spotify.com/web-api/remove-tracks-playlist/).
     **/
    private String snapshotId;
    private SpotifyUri uri;
    /**
     * Information about the tracks of the playlist.
     **/
    private Page<TrackSimple> tracks;
    /**
     * The name of the playlist.
     **/
    private String name;
    /**
     * The playlist's public/private status: `true` the playlist is public,
     * `false` the playlist is private, `null` the playlist status is not
     * relevant. For more about public/private status, see [Working with
     * Playlists](https://developer.spotify.com/web-api/working-with-playlists/).
     **/
    @JsonProperty("public")
    private Boolean isPublic;
    private ExternalUrl externalUrls;
    /**
     * Images for the playlist. The array may be empty or contain up to three
     * images. The images are returned by size in descending order. See
     * [Working with Playlists](https://developer.spotify.com/web-api/working-with-playlists/).
     * <p>
     * Note: If returned, the source URL for the image (url) is temporary and
     * will expire in less than a day.
     **/
    private List<Image> images;
    /**
     * The object type: "playlist"
     **/
    private String type;
    private SpotifyId id;
    /**
     * The user who owns the playlist.
     **/
    private UserPublic owner;

    public PlaylistSimple(String href, Boolean collaborative, String snapshotId, SpotifyUri uri, Page<TrackSimple> tracks, String name, Boolean isPublic, ExternalUrl externalUrls, List<Image> images, String type, SpotifyId id, UserPublic owner) {
        this.href = href;
        this.collaborative = collaborative;
        this.snapshotId = snapshotId;
        this.uri = uri;
        this.tracks = tracks;
        this.name = name;
        this.isPublic = isPublic;
        this.externalUrls = externalUrls;
        this.images = images;
        this.type = type;
        this.id = id;
        this.owner = owner;
    }

    public PlaylistSimple() {
    }

    public String getHref() {
        return href;
    }

    public PlaylistSimple withHref(String href) {
        this.href = href;
        return this;
    }

    public Boolean getCollaborative() {
        return collaborative;
    }

    public PlaylistSimple withCollaborative(Boolean collaborative) {
        this.collaborative = collaborative;
        return this;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public PlaylistSimple withSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
        return this;
    }

    public SpotifyUri getUri() {
        return uri;
    }

    public PlaylistSimple withUri(SpotifyUri uri) {
        this.uri = uri;
        return this;
    }

    public Page<TrackSimple> getTracks() {
        return tracks;
    }

    public PlaylistSimple withTracks(Page<TrackSimple> tracks) {
        this.tracks = tracks;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlaylistSimple withName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public PlaylistSimple withIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
        return this;
    }

    public ExternalUrl getExternalUrls() {
        return externalUrls;
    }

    public PlaylistSimple withExternalUrls(ExternalUrl externalUrls) {
        this.externalUrls = externalUrls;
        return this;
    }

    public List<Image> getImages() {
        return images;
    }

    public PlaylistSimple withImages(List<Image> images) {
        this.images = images;
        return this;
    }

    public String getType() {
        return type;
    }

    public PlaylistSimple withType(String type) {
        this.type = type;
        return this;
    }

    public SpotifyId getId() {
        return id;
    }

    public PlaylistSimple withId(SpotifyId id) {
        this.id = id;
        return this;
    }

    public UserPublic getOwner() {
        return owner;
    }

    public PlaylistSimple withOwner(UserPublic owner) {
        this.owner = owner;
        return this;
    }
}
