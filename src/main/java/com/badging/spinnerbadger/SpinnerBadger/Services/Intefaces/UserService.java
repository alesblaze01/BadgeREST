package com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces;

import com.badging.spinnerbadger.SpinnerBadger.Models.Badge;
import com.badging.spinnerbadger.SpinnerBadger.Models.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<Badge> getUsersReceivedBadgeList(long userId);
    List<Badge> getUserOwnedBadges(long userId) throws Exception;
}
