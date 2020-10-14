package com.badging.spinnerbadger.SpinnerBadger.Models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "skills")
public class Skill {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "skill_id" , nullable = false , updatable = false )
    private long id;
    @NonNull
    @Column( name = "skill_title" , unique = true , nullable = false )
    private String title;

    public Skill(){ title = ""; }

    public Skill(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return title.equals(skill.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
