package org.spotify4j.models;

import java.util.List;


public class UserPublic {
    private Followers followers;
    /**
     * The user's profile image.
     **/
    private List<Image> images;
    private ExternalUrl externalUrls;
    private SpotifyUri uri;
    /**
     * The name displayed on the user's profile. `null` if not available.
     **/
    private String displayName;
    private SpotifyUserId id;
    /**
     * A link to the Web API endpoint for this user.
     **/
    private String href;
    /**
     * The object type: "user".
     **/
    private String type;

    public UserPublic(Followers followers, List<Image> images, ExternalUrl externalUrls, SpotifyUri uri, String displayName, SpotifyUserId id, String href, String type) {
        this.followers = followers;
        this.images = images;
        this.externalUrls = externalUrls;
        this.uri = uri;
        this.displayName = displayName;
        this.id = id;
        this.href = href;
        this.type = type;
    }

    public UserPublic() {
    }

    public Followers getFollowers() {
        return followers;
    }

    public UserPublic withFollowers(Followers followers) {
        this.followers = followers;
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

    public SpotifyUri getUri() {
        return uri;
    }

    public UserPublic withUri(SpotifyUri uri) {
        this.uri = uri;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public UserPublic withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public SpotifyUserId getId() {
        return id;
    }

    public UserPublic withId(SpotifyUserId id) {
        this.id = id;
        return this;
    }

    public String getHref() {
        return href;
    }

    public UserPublic withHref(String href) {
        this.href = href;
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
