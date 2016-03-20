package org.spotify4j.models;

import java.util.Optional;
import java.lang.String;
import java.util.regex.Pattern;


/**
* The resource identifier that you can enter, for example, in the Spotify
* Desktop client's search box to locate an artist, album, or track. To find
* a Spotify URI simply right-click (on Windows) or Ctrl-Click (on a Mac) on
* the artist's or album's or track's name
**/
public class SpotifyUri {
private final String spotifyUri;
private static final Pattern PATTERN = Pattern.compile("^(spotify:)(track|album|artist):[a-zA-Z0-9]+");

protected  SpotifyUri(String spotifyUri) {
this.spotifyUri = spotifyUri;
}
public static Optional<SpotifyUri> verify(String spotifyUri) {
return PATTERN.matcher(spotifyUri).matches() ?
Optional.of(new SpotifyUri(spotifyUri)) :
Optional.empty();
}
public String getSpotifyUri() {
return spotifyUri;
}
}
