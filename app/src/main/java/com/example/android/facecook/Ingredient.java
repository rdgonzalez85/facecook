package com.example.android.facecook;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by raulrashuaman on 1/24/17.
 */

public class Ingredient implements Parcelable {

    private String mName;

    public Ingredient(String name) {
        mName = name;
    }

    public Ingredient(Parcel in) {
        mName = in.readString();
    }

    public String getName() {
        return mName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
    }

    public static final Parcelable.Creator<Ingredient> CREATOR = new Parcelable.Creator<Ingredient>() {
        public Ingredient createFromParcel(Parcel in) {
            return new Ingredient(in);
        }
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };
}
