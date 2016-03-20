package org.spotify4j.models;

import org.spotify4j.models.Image;
import java.lang.String;


public class Image {
/**
* The source URL of the image.
**/
private String url;
/**
* The image height in pixels. If unknown: `null` or not returned.
**/
private int height;
/**
* The image width in pixels. If unknown: `null` or not returned.
**/
private int width;

public  Image(String url, int height, int width) {
this.url = url;
this.height = height;
this.width = width;
}
public  Image() {
}
public String getUrl() {
return url;
}
public Image withUrl(String url) {
this.url = url;
return this;
}
public int getHeight() {
return height;
}
public Image withHeight(int height) {
this.height = height;
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
