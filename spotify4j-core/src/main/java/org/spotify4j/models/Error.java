package org.spotify4j.models;

public class Error {
    /**
     * A short description of the cause of the error.
     **/
    private String message;
    /**
     * The HTTP status code (also returned in the response header; see
     * [Response Status Codes](https://developer.spotify.com/web-api/user-
     * guide/#response-status-codes) for more information).
     **/
    private int status;

    public Error(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public Error() {
    }

    public String getMessage() {
        return message;
    }

    public Error withMessage(String message) {
        this.message = message;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Error withStatus(int status) {
        this.status = status;
        return this;
    }
}
