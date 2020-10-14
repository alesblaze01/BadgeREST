package com.badging.spinnerbadger.SpinnerBadger.Services.Implentations;

import com.badging.spinnerbadger.SpinnerBadger.Models.BadgeDTO;
import com.badging.spinnerbadger.SpinnerBadger.Models.Skill;
import com.badging.spinnerbadger.SpinnerBadger.Models.Tag;
import com.badging.spinnerbadger.SpinnerBadger.Repository.BadgeRepo;
import com.badging.spinnerbadger.SpinnerBadger.Models.Badge;
import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.BadgeService;
import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.SkillService;
import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BadgeServiceImpl implements BadgeService {
    @Autowired
    private BadgeRepo mBadgeRepo;
    @Autowired
    private SkillService mSkillService;
    @Autowired
    private TagService mTagService;

    @Override
    public List<Badge> getAllBadges(int pageNumber , int sizeOfPage) {
        if (sizeOfPage > 20) {
            sizeOfPage = 20;
        }
        final Page<Badge> allPages = mBadgeRepo.findAll(PageRequest.of(pageNumber,
                sizeOfPage));
        if (allPages.getTotalElements() > 0) {
            return allPages.toList();
        } else{
            return new ArrayList<>();
        }
    }

    @Transactional
    @Override
    public Badge save(Badge badge) {
        return mBadgeRepo.save(badge);
    }

    @Override
    public List<BadgeDTO> getBadgeUserOwns(long userId, int pageNumber, int size) {
        final Pageable of = PageRequest.of(pageNumber, size);
        final List<BadgeDTO> badgesUserOwns =
                mBadgeRepo.findBadgesUserOwns(userId, of);
        if (badgesUserOwns == null) return new ArrayList<>();
        return badgesUserOwns;
    }

    @Transactional
    @Override
    public List<Badge> getBadgeByTag(String title) throws Exception {
        final Tag tagByTitle = mTagService.getTagByTitle(title);
        if (tagByTitle.getTitle().equals("")) return new ArrayList<>();
        return mBadgeRepo.findBadgeByTag(new Tag((title))).orElseGet(ArrayList::new);
    }

    @Override
    public List<Badge> getBadgeBySkill(String title) {
        final Skill skillByTitle = mSkillService.getSkillByTitle(title);
        if (skillByTitle.getTitle().equals("")) return new ArrayList<>();
        else {
            final List<Badge> badgeList =
                    mBadgeRepo.findBadgeBySkill(skillByTitle).orElseGet(ArrayList::new);
            return badgeList;
        }
    }
}
