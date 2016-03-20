package org.spotify4j.models;

public class Error {
    /**
     * The HTTP status code (also returned in the response header; see
     * [Response Status Codes](https://developer.spotify.com/web-api/user-
     * guide/#response-status-codes) for more information).
     **/
    private int status;
    /**
     * A short description of the cause of the error.
     **/
    private String message;

    public Error(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public int getStatus() {
        return status;
    }

    public Error withStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Error withMessage(String message) {
        this.message = message;
        return this;
    }
}
