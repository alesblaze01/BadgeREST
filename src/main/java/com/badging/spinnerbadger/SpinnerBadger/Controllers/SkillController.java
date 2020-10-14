package com.badging.spinnerbadger.SpinnerBadger.Controllers;

import com.badging.spinnerbadger.SpinnerBadger.Models.Skill;
import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skill")
public class SkillController {
    @Autowired
    private SkillService mSkillService;
    @PostMapping("/save")
    public Skill saveSkill(@RequestParam(name = "skillTitle") String title) {
        return mSkillService.save(new Skill(title));
    }
}
