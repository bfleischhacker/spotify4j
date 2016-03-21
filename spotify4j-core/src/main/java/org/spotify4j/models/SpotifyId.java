package org.spotify4j.models;

import java.util.Optional;
import java.util.regex.Pattern;


/**
 * The base-62 identifier that you can find at the end of the Spotify URI (see
 * Spotify URI) for an artist, track, album, playlist, etc. Unlike a Spotify
 * URI, a Spotify ID does not clearly identify the type of resource; that
 * information is provided elsewhere in the call.
 **/
public class SpotifyId {
    private static final Pattern PATTERN = Pattern.compile("^[A-Za-z0-9]+");
    private final String spotifyId;

    protected SpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public static Optional<SpotifyId> verify(String spotifyId) {
        return PATTERN.matcher(spotifyId).matches() ?
                Optional.of(new SpotifyId(spotifyId)) :
                Optional.empty();
    }

    public String getSpotifyId() {
        return spotifyId;
    }
}
