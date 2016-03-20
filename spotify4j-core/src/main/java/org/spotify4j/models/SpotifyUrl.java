package org.spotify4j.models;

import java.util.Optional;
import java.lang.String;
import java.util.regex.Pattern;


/**
* An HTML link that opens a track, album, app, playlist or other Spotify
* resource in a Spotify client (which client is determined by the user's
* device and account settings at play.spotify.com).
**/
public class SpotifyUrl {
private final String spotifyUrl;
private static final Pattern PATTERN = Pattern.compile("^htt[p|ps]://open.spotify.com/(track|user|album|artist)/([a-zA-Z0-9]+)");

protected  SpotifyUrl(String spotifyUrl) {
this.spotifyUrl = spotifyUrl;
}
public static Optional<SpotifyUrl> verify(String spotifyUrl) {
return PATTERN.matcher(spotifyUrl).matches() ?
Optional.of(new SpotifyUrl(spotifyUrl)) :
Optional.empty();
}
public String getSpotifyUrl() {
return spotifyUrl;
}
}
