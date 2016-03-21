package org.spotify4j.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.Assert;
import org.spotify4j.SpotifyObjectMapper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

public class TestModels {

    private ObjectMapper objectMapper;

    @BeforeTest
    public void before() {
        this.objectMapper = SpotifyObjectMapper.defaultInstance;
    }

    public Path getExample(String name) throws URISyntaxException {
        return Paths.get(TestModels.class.getClassLoader().getResource("")
                .toURI()
                .resolve("../../../spotify-web-api/specifications/raml/examples/responses/")
                .resolve(name));
    }

    public Path getTestResource(String name) throws URISyntaxException {
        return Paths.get(TestModels.class.getClassLoader().getResource("")
                .toURI()
                .resolve(name));
    }

    public <T> T testSerialization(Path jsonPath, Class<T> clazz) throws IOException, URISyntaxException {
        final String example = new String(Files.readAllBytes(jsonPath));
        final T result = objectMapper.readValue(example, clazz);
        Assert.assertNotNull(result);
        return result;
    }

    public <T> T testSerialization(Path jsonPath, TypeReference<T> typeReference) throws IOException, URISyntaxException {
        final String example = new String(Files.readAllBytes(jsonPath));
        T result = objectMapper.readValue(example, typeReference);
        Assert.assertNotNull(result);
        return result;
    }

    @Test
    public void testSerializeGetPlaylistResult() throws IOException, URISyntaxException {
        final Playlist playlist = testSerialization(getExample("get-playlist.json"), Playlist.class);
        assertNull(playlist.getDescription());
        assertNotNull(playlist.getFollowers());
        assertEquals(0, playlist.getFollowers().getTotal());
    }

    @Test
    public void testSerializeGetUserPlaylistsResult() throws IOException, URISyntaxException {
        testSerialization(getExample("get-user-playlists.json"), new TypeReference<Page<PlaylistSimple>>() {
        });
    }

    @Test
    public void testSerializeGetPlaylistTracks() throws IOException, URISyntaxException {
        final Page<PlaylistTrack> tracks = testSerialization(getExample("get-playlist-tracks.json"),
                new TypeReference<Page<PlaylistTrack>>() {
                });
        assertNotNull(tracks.getItems());
        assertEquals(15, tracks.getItems().size());
    }

    @Test
    public void testSerializationGetUserSwizzelPlaylists() throws URISyntaxException, IOException {
        final Page<PlaylistSimple> playlists = testSerialization(getTestResource("get-user-playlists-wizzler.json"), new TypeReference<Page<PlaylistSimple>>() {
        });
        assertNotNull(playlists.getItems());
        assertEquals(8, playlists.getItems().size(), 8);
        assertEquals(8, playlists.getTotal());
    }
}
