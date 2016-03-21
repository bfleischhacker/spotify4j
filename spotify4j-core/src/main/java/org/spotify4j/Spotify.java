package org.spotify4j;

import org.spotify4j.api.PlaylistsResource;

public interface Spotify extends PlaylistsResource {

    PlaylistsResource playlists();
}
