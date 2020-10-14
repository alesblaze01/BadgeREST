package com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces;

import com.badging.spinnerbadger.SpinnerBadger.Models.Badge;
import com.badging.spinnerbadger.SpinnerBadger.Models.BadgeDTO;

import java.util.List;

public interface BadgeService {
    List<Badge> getAllBadges(int pageNumber , int pageSize);
    Badge save(Badge badge);
    List<BadgeDTO> getBadgeUserOwns(long userId, int pageNumber, int size);
    List<Badge> getBadgeByTag(String title) throws Exception;
    List<Badge> getBadgeBySkill(String title);
}
