
package com.nytimesapp.feature.browse.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Medium {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("subtype")
    @Expose
    private String subtype;
    @SerializedName("caption")
    @Expose
    private Object caption;
    @SerializedName("copyright")
    @Expose
    private Object copyright;
    @SerializedName("approved_for_syndication")
    @Expose
    private int approvedForSyndication;
    @SerializedName("media-metadata")
    @Expose
    private List<MediaMetadatum> mediaMetadata = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Medium() {
    }

    /**
     * 
     * @param subtype
     * @param mediaMetadata
     * @param caption
     * @param copyright
     * @param type
     * @param approvedForSyndication
     */
    public Medium(String type, String subtype, Object caption, Object copyright, int approvedForSyndication, List<MediaMetadatum> mediaMetadata) {
        super();
        this.type = type;
        this.subtype = subtype;
        this.caption = caption;
        this.copyright = copyright;
        this.approvedForSyndication = approvedForSyndication;
        this.mediaMetadata = mediaMetadata;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public Object getCaption() {
        return caption;
    }

    public void setCaption(Object caption) {
        this.caption = caption;
    }

    public Object getCopyright() {
        return copyright;
    }

    public void setCopyright(Object copyright) {
        this.copyright = copyright;
    }

    public int getApprovedForSyndication() {
        return approvedForSyndication;
    }

    public void setApprovedForSyndication(int approvedForSyndication) {
        this.approvedForSyndication = approvedForSyndication;
    }

    public List<MediaMetadatum> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(List<MediaMetadatum> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

}
