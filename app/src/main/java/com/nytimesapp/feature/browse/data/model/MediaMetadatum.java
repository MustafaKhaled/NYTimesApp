
package com.nytimesapp.feature.browse.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MediaMetadatum implements Parcelable {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("height")
    @Expose
    private int height;
    @SerializedName("width")
    @Expose
    private int width;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MediaMetadatum() {
    }

    /**
     * 
     * @param height
     * @param width
     * @param format
     * @param url
     */
    public MediaMetadatum(String url, String format, int height, int width) {
        super();
        this.url = url;
        this.format = format;
        this.height = height;
        this.width = width;
    }

    protected MediaMetadatum(Parcel in) {
        url = in.readString();
        format = in.readString();
        height = in.readInt();
        width = in.readInt();
    }

    public static final Creator<MediaMetadatum> CREATOR = new Creator<MediaMetadatum>() {
        @Override
        public MediaMetadatum createFromParcel(Parcel in) {
            return new MediaMetadatum(in);
        }

        @Override
        public MediaMetadatum[] newArray(int size) {
            return new MediaMetadatum[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(format);
        dest.writeInt(height);
        dest.writeInt(width);
    }
}
