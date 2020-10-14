package com.badging.spinnerbadger.SpinnerBadger.Services.Implentations;

import com.badging.spinnerbadger.SpinnerBadger.Models.Course;
import com.badging.spinnerbadger.SpinnerBadger.Repository.CourseRepo;
import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo mCourseRepo;

    @Override
    public Course save(@NonNull Course course) {
        return mCourseRepo.saveAndFlush(course);
    }

    @Override
    public List<Course> saveAll(List<Course> courses) {
        return mCourseRepo.saveAll(courses);
    }

    @Override
    public List<Course> getCourseByExactTitle(@NonNull String title) {
        return mCourseRepo.getCourseByTitleIgnoreCase(title).orElse(new ArrayList<>());
    }

    @Override
    public List<Course> getCourseByTitleContaining(String title) {
        return mCourseRepo.getCourseByTitleContainingIgnoreCase(title).orElse(new ArrayList<>());
    }

    @GetMapping
    public List<Course> getAllCourse() {
        return mCourseRepo.findAll();
    }
}
