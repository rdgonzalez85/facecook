package com.example.android.facecook;

/**
 * Created by raulrashuaman on 2/6/17.
 */

public class Recipe {

    private String mTitle;
    private String mDescription;
    private String mUrlImage;

    public Recipe(String mTitle, String mDescription, String mUrlImage) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mUrlImage = mUrlImage;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getUrlImage() {
        return mUrlImage;
    }

    public void setUrlImage(String mUrlImage) {
        this.mUrlImage = mUrlImage;
    }
}
