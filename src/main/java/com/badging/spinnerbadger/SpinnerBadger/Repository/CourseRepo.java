package com.badging.spinnerbadger.SpinnerBadger.Repository;

import com.badging.spinnerbadger.SpinnerBadger.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long> {
    Optional<List<Course>> getCourseByTitleIgnoreCase(String title);
    Optional<List<Course>> getCourseByTitleContainingIgnoreCase(String title);
}
