package com.badging.spinnerbadger.SpinnerBadger.Services.Implentations;

import com.badging.spinnerbadger.SpinnerBadger.Models.Skill;
import com.badging.spinnerbadger.SpinnerBadger.Repository.SkillRepo;
import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepo mSkillRepo;

    @Override
    public Skill save(Skill skill) {
        return mSkillRepo.saveAndFlush(skill);
    }

    @Override
    public Iterable<Skill> saveAll(Iterable<Skill> skills) {
        List<Skill> iterable = new ArrayList<>();
        for (Skill skill:skills) {
            iterable.add(mSkillRepo.saveAndFlush(skill));
        }
        mSkillRepo.flush();
        return iterable;
    }

    @Override
    public Skill getSkillByTitle(String title) throws NullPointerException {
        return mSkillRepo.findByTitle(title).orElse(new Skill());
    }
}
