package org.spotify4j.models;

import org.spotify4j.models.ExternalUrl;
import org.spotify4j.models.TrackLink;
import org.spotify4j.models.SpotifyId;
import org.spotify4j.models.SpotifyUri;
import java.lang.String;


public class TrackLink {
/**
* Known external URLs for this track.
**/
private ExternalUrl externalUrls;
/**
* A link to the Web API endpoint providing full details of the track.
**/
private String href;
private SpotifyId id;
/**
* The object type: "track".
**/
private String type;
private SpotifyUri uri;

public  TrackLink(ExternalUrl externalUrls, String href, SpotifyId id, String type, SpotifyUri uri) {
this.externalUrls = externalUrls;
this.href = href;
this.id = id;
this.type = type;
this.uri = uri;
}
public  TrackLink() {
}
public ExternalUrl getExternalUrls() {
return externalUrls;
}
public TrackLink withExternalUrls(ExternalUrl externalUrls) {
this.externalUrls = externalUrls;
return this;
}
public String getHref() {
return href;
}
public TrackLink withHref(String href) {
this.href = href;
return this;
}
public SpotifyId getId() {
return id;
}
public TrackLink withId(SpotifyId id) {
this.id = id;
return this;
}
public String getType() {
return type;
}
public TrackLink withType(String type) {
this.type = type;
return this;
}
public SpotifyUri getUri() {
return uri;
}
public TrackLink withUri(SpotifyUri uri) {
this.uri = uri;
return this;
}
}
