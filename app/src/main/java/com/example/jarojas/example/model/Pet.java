package com.example.jarojas.example.model;

/**
 * Created by jarojas on 17/03/17.
 */

public class Pet {
    private int id;
    private String name;
    private int rating;
    private boolean like;
    private int photoId;

    public Pet(int id, String name, int rating, boolean like, int photoId) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.like = like;
        this.photoId = photoId;
    }
    public Pet(int rating, int photoId) {
        this(0,"", rating, false, photoId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
