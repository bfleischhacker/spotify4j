package org.spotify4j.models;

import java.util.List;


/**
 * The cursor-based paging object is a container for a set of objects. It
 * contains a key called `items` (whose value is an array of the requested
 * objects) along with other keys like `next` and `cursors` that can be useful
 * in future calls.
 **/
public class CursorPage<T> extends BasePage<T> {
    /**
     * The cursors used to find the next set of items.
     **/
    private Cursor cursors;

    public CursorPage(String href, List<T> items, int limit, int total, String next, Cursor cursors) {
        super(href, items, limit, total, next);
        this.cursors = cursors;
    }

    public CursorPage() {
    }

    public Cursor getCursors() {
        return cursors;
    }

    public CursorPage withCursors(Cursor cursors) {
        this.cursors = cursors;
        return this;
    }
}
