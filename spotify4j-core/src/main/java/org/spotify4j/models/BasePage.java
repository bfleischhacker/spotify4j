package org.spotify4j.models;

import java.util.List;


/**
 * A base paging object from which Page and Cursor Page inherits.
 **/
public class BasePage<T> {
    /**
     * A link to the Web API endpoint returning the full result of
     * the request.
     **/
    private String href;
    /**
     * The requested data.
     **/
    private List<T> items;
    /**
     * The maximum number of items in the response (as set in the
     * query or by default).
     **/
    private int limit;
    /**
     * The total number of items available to return.
     **/
    private int total;
    /**
     * URL to the next page of items. (`null` if none)
     **/
    private String next;

    public BasePage(String href, List<T> items, int limit, int total, String next) {
        this.href = href;
        this.items = items;
        this.limit = limit;
        this.total = total;
        this.next = next;
    }

    public String getHref() {
        return href;
    }

    public BasePage withHref(String href) {
        this.href = href;
        return this;
    }

    public List<T> getItems() {
        return items;
    }

    public BasePage withItems(List<T> items) {
        this.items = items;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public BasePage withLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public BasePage withTotal(int total) {
        this.total = total;
        return this;
    }

    public String getNext() {
        return next;
    }

    public BasePage withNext(String next) {
        this.next = next;
        return this;
    }
}
