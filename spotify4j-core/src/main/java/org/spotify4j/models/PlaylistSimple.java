package org.spotify4j.models;

import java.util.List;
import java.util.Optional;


public class PlaylistSimple {
    /**
     * The playlist's public/private status: `true` the playlist is public,
     * `false` the playlist is private, `null` the playlist status is not
     * relevant. For more about public/private status, see [Working with
     * Playlists](https://developer.spotify.com/web-api/working-with-playlists/).
     **/
    private Optional<Boolean> isPublic;
    /**
     * The object type: "playlist"
     **/
    private String type;
    /**
     * The user who owns the playlist.
     **/
    private UserPublic owner;
    private SpotifyId id;
    /**
     * The name of the playlist.
     **/
    private String name;
    /**
     * Information about the tracks of the playlist.
     **/
    private Page<TrackSimple> tracks;
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
     * The version identifier for the current playlist. Can be supplied in
     * other requests to target a specific playlist version: see [Remove
     * tracks from a playlist](https://developer.spotify.com/web-api/remove-tracks-playlist/).
     **/
    private String snapshotId;
    /**
     * `true` if the owner allows other users to modify the playlist.
     **/
    private Boolean collaborative;
    private ExternalUrl externalUrls;
    private SpotifyUri uri;
    /**
     * A link to the Web API endpoint providing full details of the playlist.
     **/
    private String href;

    public PlaylistSimple(Optional<Boolean> isPublic, String type, UserPublic owner, SpotifyId id, String name, Page<TrackSimple> tracks, List<Image> images, String snapshotId, Boolean collaborative, ExternalUrl externalUrls, SpotifyUri uri, String href) {
        this.isPublic = isPublic;
        this.type = type;
        this.owner = owner;
        this.id = id;
        this.name = name;
        this.tracks = tracks;
        this.images = images;
        this.snapshotId = snapshotId;
        this.collaborative = collaborative;
        this.externalUrls = externalUrls;
        this.uri = uri;
        this.href = href;
    }

    public PlaylistSimple() {
    }

    public Optional<Boolean> getIsPublic() {
        return isPublic;
    }

    public PlaylistSimple withIsPublic(Optional<Boolean> isPublic) {
        this.isPublic = isPublic;
        return this;
    }

    public String getType() {
        return type;
    }

    public PlaylistSimple withType(String type) {
        this.type = type;
        return this;
    }

    public UserPublic getOwner() {
        return owner;
    }

    public PlaylistSimple withOwner(UserPublic owner) {
        this.owner = owner;
        return this;
    }

    public SpotifyId getId() {
        return id;
    }

    public PlaylistSimple withId(SpotifyId id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlaylistSimple withName(String name) {
        this.name = name;
        return this;
    }

    public Page<TrackSimple> getTracks() {
        return tracks;
    }

    public PlaylistSimple withTracks(Page<TrackSimple> tracks) {
        this.tracks = tracks;
        return this;
    }

    public List<Image> getImages() {
        return images;
    }

    public PlaylistSimple withImages(List<Image> images) {
        this.images = images;
        return this;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public PlaylistSimple withSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
        return this;
    }

    public Boolean getCollaborative() {
        return collaborative;
    }

    public PlaylistSimple withCollaborative(Boolean collaborative) {
        this.collaborative = collaborative;
        return this;
    }

    public ExternalUrl getExternalUrls() {
        return externalUrls;
    }

    public PlaylistSimple withExternalUrls(ExternalUrl externalUrls) {
        this.externalUrls = externalUrls;
        return this;
    }

    public SpotifyUri getUri() {
        return uri;
    }

    public PlaylistSimple withUri(SpotifyUri uri) {
        this.uri = uri;
        return this;
    }

    public String getHref() {
        return href;
    }

    public PlaylistSimple withHref(String href) {
        this.href = href;
        return this;
    }
}
