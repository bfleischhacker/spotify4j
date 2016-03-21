package org.spotify4j.models;

import java.util.List;


public class UserPrivate extends UserPublic {
    /**
     * The user's date-of-birth.
     **/
    private String birthday;
    /**
     * The user's Spotify subscription level: "premium", "free", etc. (The
     * subscription level "open" can be considered the same as "free".)
     **/
    private Product product;
    /**
     * The user's email address, as entered by the user when creating their
     * account.
     * <p>
     * **Important!** This email address is unverified; there is no proof
     * that it actually belongs to the user.
     **/
    private String email;
    /**
     * The country of the user, as set in the user's account profile. An
     * [ISO 3166-1 alpha-2 country code](http://en.wikipedia.org/wiki/
     * ISO_3166-1_alpha-2).
     **/
    private String country;

    public enum Product {premium, free, open}

    public UserPrivate(Followers followers, List<Image> images, ExternalUrl externalUrls, SpotifyUri uri, String displayName, SpotifyUserId id, String href, String type, String birthday, Product product, String email, String country) {
        super(followers, images, externalUrls, uri, displayName, id, href, type);
        this.birthday = birthday;
        this.product = product;
        this.email = email;
        this.country = country;
    }

    public UserPrivate() {
        super();
    }

    public String getBirthday() {
        return birthday;
    }

    public UserPrivate withBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public UserPrivate withProduct(Product product) {
        this.product = product;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserPrivate withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserPrivate withCountry(String country) {
        this.country = country;
        return this;
    }
}
