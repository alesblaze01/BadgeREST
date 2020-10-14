package com.badging.spinnerbadger.SpinnerBadger.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "badges")
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "badge_id" , nullable = false , updatable = false )
    private long mId;

    @NonNull
    @Column(name = "badge_name" , nullable = false , unique = true)
    private String mName;


    @Column(name = "badge_description" , length = 60000)
    private String mDescription;

    @Lob
    @NonNull
    @Column(name = "badge_logo" , nullable = false )
    private String mLogo;

    @NonNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "issuer_id", referencedColumnName = "user_id", nullable = false)
    private User mIssuer;

    @NonNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinTable(name = "badge_tags" , joinColumns = {
            @JoinColumn(name = "badge_id")
    } , inverseJoinColumns = {
            @JoinColumn(name = "tag_id")
    } , uniqueConstraints = {
            @UniqueConstraint(columnNames = {"badge_id","tag_id"})
    })
    private List<Tag> mTagList;


    @NonNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinTable(name = "badge_skills" , joinColumns = {
            @JoinColumn(name = "badge_id")
    } , inverseJoinColumns = {
            @JoinColumn(name = "skill_id")
    } , uniqueConstraints = {
            @UniqueConstraint(columnNames = {"badge_id" , "skill_id"})
    })
    private List<Skill> mSkillList;

    @NonNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(cascade = CascadeType.ALL , fetch =  FetchType.LAZY)
    @JoinTable(name = "badge_courses" , joinColumns = {
            @JoinColumn(name = "badge_id")
    }, inverseJoinColumns =  {
            @JoinColumn(name = "course_id")
    } , uniqueConstraints =  {
            @UniqueConstraint(columnNames = {"badge_id" , "course_id"})
    })
    private List<Course> mCourseList;

    public List<Skill> getSkillList() {
        return mSkillList;
    }

    public void setSkillList(List<Skill> skillList) {
        mSkillList = skillList;
    }

    public Badge() {
        mTagList = new ArrayList<>();
        mSkillList = new ArrayList<>();
    }

    public List<Tag> getTagList() {
        return mTagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.mTagList = tagList;
    }

    public long getId() {
        return mId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Badge badge = (Badge) o;
        return mId == badge.mId &&
                mName.equals(badge.mName) &&
                Objects.equals(mDescription, badge.mDescription) &&
                mLogo.equals(badge.mLogo) &&
                mIssuer.equals(badge.mIssuer) &&
                Objects.equals(mTagList, badge.mTagList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mName, mDescription, mLogo, mIssuer, mTagList);
    }

    public void setId(long id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getLogo() {
        return mLogo;
    }

    public void setLogo(String logo) {
        mLogo = logo;
    }

    public User getIssuer() {
        return mIssuer;
    }

    public void setIssuer(User issuer) {
        mIssuer = issuer;
    }

    @Override
    public String toString() {
        return "Badge{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mLogo='" + mLogo + '\'' +
                ", mIssuer=" + mIssuer +
                ", mTagList=" + mTagList +
                '}';
    }

    public List<Course> getCourseList() {
        return mCourseList;
    }

    public void setCourseList(List<Course> courseList) {
        mCourseList = courseList;
    }
}
