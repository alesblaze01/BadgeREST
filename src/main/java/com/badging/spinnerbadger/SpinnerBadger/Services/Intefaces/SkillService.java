package com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces;

import com.badging.spinnerbadger.SpinnerBadger.Models.Skill;
import org.springframework.lang.NonNull;


public interface SkillService {
    Skill save(@NonNull Skill skill);
    Iterable<Skill> saveAll(@NonNull Iterable<Skill> skills);
    Skill getSkillByTitle(@NonNull String title);
}
