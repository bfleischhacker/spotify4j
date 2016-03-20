package org.spotify4j.models;

import java.util.List;


/**
 * The offset-based paging object is a container for a set of objects.
 * It contains a key called items (whose value is an array of the
 * requested objects) along with other keys like previous, next and
 * limit that can be useful in future calls.
 **/
public class Page<T> extends BasePage<T> {
    /**
     * The offset of the items returned (as set in the query or by
     * default).
     **/
    private int offset;
    /**
     * URL to the previous page of items. (`null` if none)
     **/
    private String previous;

    public Page(String href, List<T> items, int limit, int total, String next, int offset, String previous) {
        super(href, items, limit, total, next);
        this.offset = offset;
        this.previous = previous;
    }

    public int getOffset() {
        return offset;
    }

    public Page withOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public String getPrevious() {
        return previous;
    }

    public Page withPrevious(String previous) {
        this.previous = previous;
        return this;
    }
}
