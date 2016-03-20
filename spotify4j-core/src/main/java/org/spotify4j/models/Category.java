package org.spotify4j.models;

import java.util.List;


public class Category {
    /**
     * A link to the Web API endpoint returning full details of
     * the category.
     **/
    private String href;
    private SpotifyCategoryId id;
    private List<Image> icons;
    /**
     * The name of the category.
     **/
    private String name;

    public Category(String href, SpotifyCategoryId id, List<Image> icons, String name) {
        this.href = href;
        this.id = id;
        this.icons = icons;
        this.name = name;
    }

    public Category() {
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

    public String getName() {
        return name;
    }

    public Category withName(String name) {
        this.name = name;
        return this;
    }
}
