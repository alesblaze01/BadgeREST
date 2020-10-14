package com.badging.spinnerbadger.SpinnerBadger.Models;

public class BadgeDTO {
    private long mId;
    private String mName;
    private String mDescription;
    private String mLogo;
    private String mFullName;
    private String mUserName;
    private long mUserId;

    public BadgeDTO(long id , String name , String description , String logo ,
                    String fullName , String userName , long userId){
        mId = id;
        mName = name;
        mDescription = description;
        mLogo= logo;
        mFullName = fullName;
        mUserName = userName;
        mUserId = userId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public long getUserId() {
        return mUserId;
    }

    public void setUserId(long userId) {
        mUserId = userId;
    }

    public BadgeDTO(){}
    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getLogo() {
        return mLogo;
    }

    public void setLogo(String logo) {
        mLogo = logo;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    @Override
    public String toString() {
        return "BadgeDTO{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mLogo='" + mLogo + '\'' +
                ", mFullName='" + mFullName + '\'' +
                ", mUserName='" + mUserName + '\'' +
                ", mUserId=" + mUserId +
                '}';
    }
}

