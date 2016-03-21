package org.spotify4j.models;

public class Image {
    /**
     * The image height in pixels. If unknown: `null` or not returned.
     **/
    private int height;
    /**
     * The source URL of the image.
     **/
    private String url;
    /**
     * The image width in pixels. If unknown: `null` or not returned.
     **/
    private int width;

    public Image(int height, String url, int width) {
        this.height = height;
        this.url = url;
        this.width = width;
    }

    public Image() {
    }

    public int getHeight() {
        return height;
    }

    public Image withHeight(int height) {
        this.height = height;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Image withUrl(String url) {
        this.url = url;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public Image withWidth(int width) {
        this.width = width;
        return this;
    }
}
