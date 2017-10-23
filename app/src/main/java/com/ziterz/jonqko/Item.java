package com.ziterz.jonqko;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ziterz on 10/23/2017.
 */

public class Item implements Parcelable {
    int img;

    public Item(int img) {
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.img);
    }

    protected Item(Parcel in) {
        this.img = in.readInt();
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
