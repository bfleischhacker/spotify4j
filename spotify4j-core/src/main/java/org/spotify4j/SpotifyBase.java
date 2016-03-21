package org.spotify4j;

import org.spotify4j.models.Page;

public interface SpotifyBase {

    <T> Page<T> fetchNext(Page<T> page);

    <T> Page<T> fetchPrevious(Page<T> page);
}
