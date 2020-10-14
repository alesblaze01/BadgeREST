package com.badging.spinnerbadger.SpinnerBadger.Services.Implentations;

import com.badging.spinnerbadger.SpinnerBadger.Models.Badge;
import com.badging.spinnerbadger.SpinnerBadger.Models.User;
import com.badging.spinnerbadger.SpinnerBadger.Repository.UserRepo;
import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo mUserRepo;

    @Override
    @Transactional
    public User save(User user) {
        return mUserRepo.saveAndFlush(user);
    }

    @Override
    public List<Badge> getUsersReceivedBadgeList(long userId) {
        final Optional<User> byId = mUserRepo.findById(userId);
        return byId.orElse(new User()).getReceivedBadges();
    }

    @Override
    public List<Badge> getUserOwnedBadges(long userId) throws Exception {
        final Optional<User> byId = mUserRepo.findById(userId);
        byId.orElseThrow(Exception::new);
        return byId.get().getReceivedBadges();
    }
}
