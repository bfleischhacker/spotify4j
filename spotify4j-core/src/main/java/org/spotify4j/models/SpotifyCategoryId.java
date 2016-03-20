package org.spotify4j.models;

import java.util.Optional;
import java.util.regex.Pattern;
import java.lang.String;


/**
* The unique string identifying the Spotify category that you can find at the
* end of the Spotify URI for the category.
**/
public class SpotifyCategoryId {
private static final Pattern PATTERN = Pattern.compile("^[A-Za-z0-9]+");
private final String spotifyCategoryId;

protected  SpotifyCategoryId(String spotifyCategoryId) {
this.spotifyCategoryId = spotifyCategoryId;
}
public static Optional<SpotifyCategoryId> verify(String spotifyCategoryId) {
return PATTERN.matcher(spotifyCategoryId).matches() ?
Optional.of(new SpotifyCategoryId(spotifyCategoryId)) :
Optional.empty();
}
public String getSpotifyCategoryId() {
return spotifyCategoryId;
}
}
