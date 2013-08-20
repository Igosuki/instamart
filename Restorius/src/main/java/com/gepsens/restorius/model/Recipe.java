package com.gepsens.restorius.model;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.io.File;
import java.util.Date;

@ParseClassName("Recipe")
public class Recipe extends ParseObject {


    public Double getRating() {
        return getDouble("rating");
    }

    public void setRating(Double rating) {
        put("rating", rating);
    }

    public ParseFile getThumbnail() {
        return getParseFile("thumbnail");
    }

    public void setThumbnail(ParseFile thumbnail) {
        put("thumbnail", thumbnail);
    }

    public String getTitle() {
        return getString("title");
    }

    public void setTitle(String title) {
        put("title", title);
    }

    public ParseUser getUploader() {
        return getParseUser("uploader");
    }

    public void setUploader(ParseUser uploader) {
        put("uploader", uploader);
    }

    public Date getCreatedAt() {
        return getDate("createdAt");
    }

    public void setCreatedAt(Date createdAt) {
        put("createdAt", createdAt);
    }

    public Date getUpdatedAt() {
        return getDate("updatedAt");
    }

    public void setUpdatedAt(Date updatedAt) {
        put("updatedAt", updatedAt);
    }
}
