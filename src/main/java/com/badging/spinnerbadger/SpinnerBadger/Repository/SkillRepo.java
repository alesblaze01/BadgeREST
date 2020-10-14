package com.badging.spinnerbadger.SpinnerBadger.Repository;

import com.badging.spinnerbadger.SpinnerBadger.Models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepo extends JpaRepository<Skill,Long> {
    Optional<Skill> findByTitle(String title);
}
