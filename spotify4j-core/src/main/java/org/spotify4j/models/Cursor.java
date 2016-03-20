package org.spotify4j.models;

import org.spotify4j.models.Cursor;
import java.lang.String;


public class Cursor {
/**
* The cursor to use as key to find the next page of items.
**/
private String after;

public  Cursor(String after) {
this.after = after;
}
public  Cursor() {
}
public String getAfter() {
return after;
}
public Cursor withAfter(String after) {
this.after = after;
return this;
}
}
