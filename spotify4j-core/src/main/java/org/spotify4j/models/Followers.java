package org.spotify4j.models;

/**
 * Information about the followers of an item.
 **/
public class Followers {
    /**
     * The total number of followers.
     **/
    private int total;
    /**
     * A link to the Web API endpoint providing full details of the
     * followers; null if not available. Please note that this will
     * always be set to `null`, as the Web API does not support it
     * at the moment.
     **/
    private String href;

    public Followers(int total, String href) {
        this.total = total;
        this.href = href;
    }

    public Followers() {
    }

    public int getTotal() {
        return total;
    }

    public Followers withTotal(int total) {
        this.total = total;
        return this;
    }

    public String getHref() {
        return href;
    }

    public Followers withHref(String href) {
        this.href = href;
        return this;
    }
}
