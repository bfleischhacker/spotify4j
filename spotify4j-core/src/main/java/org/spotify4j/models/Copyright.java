package org.spotify4j.models;

public class Copyright {
    /**
     * The type of copyright: C = the copyright, P = the sound recording
     * (performance) copyright.
     **/
    private Type type;
    /**
     * The copyright text for this album.
     **/
    private String text;

    public enum Type {C, P}

    public Copyright(Type type, String text) {
        this.type = type;
        this.text = text;
    }

    public Copyright() {
    }

    public Type getType() {
        return type;
    }

    public Copyright withType(Type type) {
        this.type = type;
        return this;
    }

    public String getText() {
        return text;
    }

    public Copyright withText(String text) {
        this.text = text;
        return this;
    }
}
