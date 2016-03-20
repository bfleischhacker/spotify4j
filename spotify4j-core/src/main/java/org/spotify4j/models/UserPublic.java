package org.spotify4j.models;

import java.util.List;


public class UserPublic {
    private SpotifyUri uri;
    private Followers followers;
    /**
     * A link to the Web API endpoint for this user.
     **/
    private String href;
    /**
     * The name displayed on the user's profile. `null` if not available.
     **/
    private String displayName;
    /**
     * The user's profile image.
     **/
    private List<Image> images;
    private ExternalUrl externalUrls;
    private SpotifyUserId id;
    /**
     * The object type: "user".
     **/
    private String type;

    public UserPublic(SpotifyUri uri, Followers followers, String href, String displayName, List<Image> images, ExternalUrl externalUrls, SpotifyUserId id, String type) {
        this.uri = uri;
        this.followers = followers;
        this.href = href;
        this.displayName = displayName;
        this.images = images;
        this.externalUrls = externalUrls;
        this.id = id;
        this.type = type;
    }

    public UserPublic() {
    }

    public SpotifyUri getUri() {
        return uri;
    }

    public UserPublic withUri(SpotifyUri uri) {
        this.uri = uri;
        return this;
    }

    public Followers getFollowers() {
        return followers;
    }

    public UserPublic withFollowers(Followers followers) {
        this.followers = followers;
        return this;
    }

    public String getHref() {
        return href;
    }

    public UserPublic withHref(String href) {
        this.href = href;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public UserPublic withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public List<Image> getImages() {
        return images;
    }

    public UserPublic withImages(List<Image> images) {
        this.images = images;
        return this;
    }

    public ExternalUrl getExternalUrls() {
        return externalUrls;
    }

    public UserPublic withExternalUrls(ExternalUrl externalUrls) {
        this.externalUrls = externalUrls;
        return this;
    }

    public SpotifyUserId getId() {
        return id;
    }

    public UserPublic withId(SpotifyUserId id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public UserPublic withType(String type) {
        this.type = type;
        return this;
    }
}
