package org.spotify4j.models;


/**
 * Known external IDs for object
 **/
public class ExternalId {
    private String isrc;
    private String ean;
    private String upc;

    public ExternalId(String isrc, String ean, String upc) {
        this.isrc = isrc;
        this.ean = ean;
        this.upc = upc;
    }

    public ExternalId() {
    }

    public String getIsrc() {
        return isrc;
    }

    public ExternalId withIsrc(String isrc) {
        this.isrc = isrc;
        return this;
    }

    public String getEan() {
        return ean;
    }

    public ExternalId withEan(String ean) {
        this.ean = ean;
        return this;
    }

    public String getUpc() {
        return upc;
    }

    public ExternalId withUpc(String upc) {
        this.upc = upc;
        return this;
    }
}
