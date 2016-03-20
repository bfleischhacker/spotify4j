package org.spotify4j.models;

import org.spotify4j.models.UserPublic;
import org.spotify4j.models.Playlist;
import java.util.List;
import org.spotify4j.models.ExternalUrl;
import org.spotify4j.models.SpotifyId;
import org.spotify4j.models.Page;
import org.spotify4j.models.SpotifyUri;
import java.util.Optional;
import java.lang.Boolean;
import java.lang.String;
import org.spotify4j.models.Followers;


public class Playlist extends PlaylistSimple {
/**
* Information about the followers of the playlist.
**/
private Followers followers;
/**
* The playlist description. Only returned for modified, verified
* playlists, otherwise `null`.
**/
private String description;

public  Playlist(Optional<Boolean> isPublic, String type, UserPublic owner, SpotifyId id, String name, Page<TrackSimple> tracks, List<Image> images, String snapshotId, Boolean collaborative, ExternalUrl externalUrls, SpotifyUri uri, String href, Followers followers, String description) {
super(isPublic, type, owner, id, name, tracks, images, snapshotId, collaborative, externalUrls, uri, href);
this.followers = followers;
this.description = description;
}
public  Playlist() {
super();
}
public Followers getFollowers() {
return followers;
}
public Playlist withFollowers(Followers followers) {
this.followers = followers;
return this;
}
public String getDescription() {
return description;
}
public Playlist withDescription(String description) {
this.description = description;
return this;
}
}