package com.badging.spinnerbadger.SpinnerBadger.Models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id" , updatable = false)
    private long mId;
    @NonNull
    @Column(name = "username" , nullable = false , unique = true)
    private String mUserName;
    @NonNull
    @Column(name = "fullname",nullable = false)
    private String mFullName;
    @NonNull
    @Column(name = "salt" , nullable = false)
    private String mSalt;
    //TODO:: No need to worry about received badges
    @OneToMany
    @JoinColumn(name = "received_badges_id")
    private List<Badge> mReceivedBadges;

    public User() {
        mReceivedBadges = new ArrayList<>();
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getSalt() {
        return mSalt;
    }

    public void setSalt(String salt) {
        mSalt = salt;
    }

    public List<Badge> getReceivedBadges() {
        return mReceivedBadges;
    }

    public void setReceivedBadges(List<Badge> receivedBadges) {
        mReceivedBadges = receivedBadges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return mUserName.equals(user.mUserName) &&
                mFullName.equals(user.mFullName) &&
                mSalt.equals(user.mSalt) &&
                Objects.equals(mReceivedBadges, user.mReceivedBadges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mUserName, mFullName, mSalt/*, mOwnedBadges*/, mReceivedBadges);
    }

    @Override
    public String toString() {
        return "User{" +
                "mId=" + mId +
                ", mUserName='" + mUserName + '\'' +
                ", mFullName='" + mFullName + '\'' +
                ", mSalt='" + mSalt + '\'' +
                '}';
    }
}
