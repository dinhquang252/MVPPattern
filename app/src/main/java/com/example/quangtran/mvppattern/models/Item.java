package com.example.quangtran.mvppattern.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item implements Parcelable {
    @SerializedName("login")
    @Expose
    private String mLogin;
    @SerializedName("id")
    @Expose
    private Integer mId;
    @SerializedName("avatar_url")
    @Expose
    private String mAvatarUrl;
    @SerializedName("gravatar_id")
    @Expose
    private String mGravatarId;
    @SerializedName("url")
    @Expose
    private String mUrl;
    @SerializedName("html_url")
    @Expose
    private String mHtmlUrl;
    @SerializedName("followers_url")
    @Expose
    private String mFollowersUrl;
    @SerializedName("following_url")
    @Expose
    private String mFollowingUrl;
    @SerializedName("gists_url")
    @Expose
    private String mGistsurl;
    @SerializedName("starred_url")
    @Expose
    private String mStarredUrl;
    @SerializedName("subscriptions_url")
    @Expose
    private String mSubscriptionsUrl;
    @SerializedName("organizations_url")
    @Expose
    private String mOrganizationsUrl;
    @SerializedName("repos_url")
    @Expose
    private String mReposUrl;
    @SerializedName("events_url")
    @Expose
    private String mEventsUrl;
    @SerializedName("received_events_url")
    @Expose
    private String mReceivedEventsUrl;
    @SerializedName("type")
    @Expose
    private String mType;
    @SerializedName("site_admin")
    @Expose
    private Boolean mSiteAdmin;
    @SerializedName("score")
    @Expose
    private Double mScore;

    protected Item(Parcel in) {
        mLogin = in.readString();
        if (in.readByte() == 0) {
            mId = null;
        } else {
            mId = in.readInt();
        }
        mAvatarUrl = in.readString();
        mGravatarId = in.readString();
        mUrl = in.readString();
        mHtmlUrl = in.readString();
        mFollowersUrl = in.readString();
        mFollowingUrl = in.readString();
        mGistsurl = in.readString();
        mStarredUrl = in.readString();
        mSubscriptionsUrl = in.readString();
        mOrganizationsUrl = in.readString();
        mReposUrl = in.readString();
        mEventsUrl = in.readString();
        mReceivedEventsUrl = in.readString();
        mType = in.readString();
        byte tmpSiteAdmin = in.readByte();
        mSiteAdmin = tmpSiteAdmin == 0 ? null : tmpSiteAdmin == 1;
        if (in.readByte() == 0) {
            mScore = null;
        } else {
            mScore = in.readDouble();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mLogin);
        if (mId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(mId);
        }
        dest.writeString(mAvatarUrl);
        dest.writeString(mGravatarId);
        dest.writeString(mUrl);
        dest.writeString(mHtmlUrl);
        dest.writeString(mFollowersUrl);
        dest.writeString(mFollowingUrl);
        dest.writeString(mGistsurl);
        dest.writeString(mStarredUrl);
        dest.writeString(mSubscriptionsUrl);
        dest.writeString(mOrganizationsUrl);
        dest.writeString(mReposUrl);
        dest.writeString(mEventsUrl);
        dest.writeString(mReceivedEventsUrl);
        dest.writeString(mType);
        dest.writeByte((byte) (mSiteAdmin == null ? 0 : mSiteAdmin ? 1 : 2));
        if (mScore == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(mScore);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getLogin() {
        return mLogin;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        this.mId = id;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public String getType() {
        return mType;
    }

    public void setType(String mType) {
        this.mType = mType;
    }
}
