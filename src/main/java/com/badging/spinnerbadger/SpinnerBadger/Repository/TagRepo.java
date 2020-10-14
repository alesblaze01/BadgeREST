package com.badging.spinnerbadger.SpinnerBadger.Repository;

import com.badging.spinnerbadger.SpinnerBadger.Models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepo extends JpaRepository<Tag,Long> {
    Optional<Tag> findByTitle(String title);
}
