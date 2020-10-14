package com.badging.spinnerbadger.SpinnerBadger.Models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tags")
public class Tag {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id" , nullable = false , updatable = false)
    private long mId;

    @NonNull
    @Column(name = "tag_title" , nullable = false )
    private String title;

    public Tag() {
        title = "";
    }

    public Tag(String title) {this.title = title;}

    @Override
    public String toString() {
        return "Tag{" +
                "mId=" + mId +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return title.equals(tag.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, title/*, mBadge*/);
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
