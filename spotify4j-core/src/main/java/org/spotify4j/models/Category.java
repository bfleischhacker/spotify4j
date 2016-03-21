package org.spotify4j.models;

import java.util.List;


public class Category {
    /**
     * The name of the category.
     **/
    private String name;
    /**
     * A link to the Web API endpoint returning full details of
     * the category.
     **/
    private String href;
    private SpotifyCategoryId id;
    private List<Image> icons;

    public Category(String name, String href, SpotifyCategoryId id, List<Image> icons) {
        this.name = name;
        this.href = href;
        this.id = id;
        this.icons = icons;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public Category withName(String name) {
        this.name = name;
        return this;
    }

    public String getHref() {
        return href;
    }

    public Category withHref(String href) {
        this.href = href;
        return this;
    }

    public SpotifyCategoryId getId() {
        return id;
    }

    public Category withId(SpotifyCategoryId id) {
        this.id = id;
        return this;
    }

    public List<Image> getIcons() {
        return icons;
    }

    public Category withIcons(List<Image> icons) {
        this.icons = icons;
        return this;
    }
}
