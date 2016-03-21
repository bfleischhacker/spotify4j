package org.spotify4j.models;

import java.util.List;


public class Playlist extends PlaylistSimple {
    /**
     * The playlist description. Only returned for modified, verified
     * playlists, otherwise `null`.
     **/
    private String description;
    /**
     * Information about the followers of the playlist.
     **/
    private Followers followers;

    public Playlist(String href, Boolean collaborative, String snapshotId, SpotifyUri uri, Page<TrackSimple> tracks, String name, Boolean isPublic, ExternalUrl externalUrls, List<Image> images, String type, SpotifyId id, UserPublic owner, String description, Followers followers) {
        super(href, collaborative, snapshotId, uri, tracks, name, isPublic, externalUrls, images, type, id, owner);
        this.description = description;
        this.followers = followers;
    }

    public Playlist() {
        super();
    }

    public String getDescription() {
        return description;
    }

    public Playlist withDescription(String description) {
        this.description = description;
        return this;
    }

    public Followers getFollowers() {
        return followers;
    }

    public Playlist withFollowers(Followers followers) {
        this.followers = followers;
        return this;
    }
}
