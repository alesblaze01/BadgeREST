package com.badging.spinnerbadger.SpinnerBadger.Controllers;

import com.badging.spinnerbadger.SpinnerBadger.Models.Badge;
import com.badging.spinnerbadger.SpinnerBadger.Models.BadgeDTO;
import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/badge")
public class BadgeController {
    @Autowired
    private BadgeService mBadgeService;

    @GetMapping("/all")
    public List<Badge> getAllBadge(@RequestParam(name = "pagenumber") int pageNumber ,
                                   @RequestParam(name = "pagesize") int pageSize) {
        return mBadgeService.getAllBadges(pageNumber,pageSize);
    }

    @PostMapping("/user")
    public List<BadgeDTO> getUserOwnedBadges(@RequestParam(name = "id") long userId ,
                                             @RequestParam(name = "pagenumber") int pageNumber ,
                                             @RequestParam(name = "pagesize") int pageSize) {
        return mBadgeService.getBadgeUserOwns(userId,pageNumber,pageSize);
    }

    @Transactional
    @GetMapping("/tag")
    public List<Badge> getBadgeByTag(@RequestParam(name = "title") String title) throws Exception {
        return mBadgeService.getBadgeByTag(title);
    }

    @Transactional
    @GetMapping("/skill")
    public List<Badge> getBadgeBySkill(@RequestParam(name = "title") String title) {
        return mBadgeService.getBadgeBySkill(title);
    }
}
