package org.spotify4j;

import org.spotify4j.api.PlaylistsResource;
import org.spotify4j.models.Page;
import org.spotify4j.models.PlaylistSimple;

public class SpotifyImpl implements Spotify {
    @Override
    public Page<PlaylistSimple> getUserPlaylists(String userId) {
        return
    }

    @Override
    public PlaylistsResource playlists() {
        return this;
    }
}
