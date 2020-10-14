package com.badging.spinnerbadger.SpinnerBadger.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id" , updatable = false)
    private long id;
    @Column(name = "title" , nullable = false )
    private String title;
    @Column(name = "url")
    private String url;
}
