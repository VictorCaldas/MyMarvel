package com.mymarvel.core.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataWrapper<T> {

    @JsonProperty("code")
    public int mCode;
    @JsonProperty("status")
    public String mStatus;
    @JsonProperty("copyright")
    public String mCopyright;
    @JsonProperty("attributionText")
    public String mAttributionText;
    @JsonProperty("attributionHTML")
    public String mAttributionHTML;
    @JsonProperty("etag")
    public String mETag;
    @JsonProperty("data")
    public DataContainer<T> mData;

    public DataWrapper() {
    }

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        mCode = code;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getCopyright() {
        return mCopyright;
    }

    public void setCopyright(String copyright) {
        mCopyright = copyright;
    }

    public String getAttributionText() {
        return mAttributionText;
    }

    public void setAttributionText(String attributionText) {
        mAttributionText = attributionText;
    }

    public String getAttributionHTML() {
        return mAttributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        mAttributionHTML = attributionHTML;
    }

    public String getETag() {
        return mETag;
    }

    public void setETag(String eTag) {
        mETag = eTag;
    }

    public DataContainer<T> getData() {
        return mData;
    }

    public void setData(DataContainer<T> data) {
        mData = data;
    }
}
