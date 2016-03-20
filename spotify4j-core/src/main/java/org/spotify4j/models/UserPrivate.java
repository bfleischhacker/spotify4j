package org.spotify4j.models;

import java.util.List;


public class UserPrivate extends UserPublic {
    /**
     * The country of the user, as set in the user's account profile. An
     * [ISO 3166-1 alpha-2 country code](http://en.wikipedia.org/wiki/
     * ISO_3166-1_alpha-2).
     **/
    private String country;
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

    public enum Product {premium, free, open}

    public UserPrivate(SpotifyUri uri, Followers followers, String href, String displayName, List<Image> images, ExternalUrl externalUrls, SpotifyUserId id, String type, String country, String birthday, Product product, String email) {
        super(uri, followers, href, displayName, images, externalUrls, id, type);
        this.country = country;
        this.birthday = birthday;
        this.product = product;
        this.email = email;
    }

    public UserPrivate() {
        super();
    }

    public String getCountry() {
        return country;
    }

    public UserPrivate withCountry(String country) {
        this.country = country;
        return this;
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
}
