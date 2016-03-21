package org.spotify4j.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
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

    public String loadExample(String name) throws URISyntaxException, IOException {
        final Path examplePath = Paths.get(TestModels.class.getClassLoader().getResource("")
                .toURI()
                .resolve("../../../spotify-web-api/specifications/raml/examples/responses/")
                .resolve(name));
        return new String(Files.readAllBytes(examplePath));
    }

    public <T> T testSerialization(String exampleFilename, Class<T> clazz) throws IOException, URISyntaxException {
        final String example = loadExample(exampleFilename);
        final T result = objectMapper.readValue(example, clazz);
        Assert.assertNotNull(result);
        return result;
    }

    public <T> T testSerialization(String exampleFilename, TypeReference<T> typeReference) throws IOException, URISyntaxException {
        final String example = loadExample(exampleFilename);
        T result = objectMapper.readValue(example, typeReference);
        Assert.assertNotNull(result);
        return result;
    }

    @Test
    public void testSerializeGetPlaylistResult() throws IOException, URISyntaxException {
        final Playlist playlist = testSerialization("get-playlist.json", Playlist.class);
        assertNull(playlist.getDescription());
        assertNotNull(playlist.getFollowers());
        assertEquals(playlist.getFollowers().getTotal(), 0);
    }

    @Test
    public void testSerializeGetUserPlaylistsResult() throws IOException, URISyntaxException {
        testSerialization("get-user-playlists.json", new TypeReference<Page<PlaylistSimple>>() {
        });
    }

    @Test
    public void testSerializeGetPlaylistTracks() throws IOException, URISyntaxException {
        final Page<PlaylistTrack> tracks = testSerialization("get-playlist-tracks.json", new TypeReference<Page<PlaylistTrack>>() {
        });
        assertNotNull(tracks.getItems());
        assertEquals(tracks.getItems().size(), 15);
    }
}
