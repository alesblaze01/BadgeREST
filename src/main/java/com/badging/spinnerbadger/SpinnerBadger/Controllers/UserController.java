package com.badging.spinnerbadger.SpinnerBadger.Controllers;

import com.badging.spinnerbadger.SpinnerBadger.Models.Badge;
import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService mUserService;

//    @PostMapping("/receivelist")
//    public List<Badge> getUsersReceivedBadgesList(@RequestParam(name = "id") long userId) {
//        final List<Badge> usersReceivedBadgeList = mUserService.getUsersReceivedBadgeList(userId);
//        System.out.println();
//        System.err.println(usersReceivedBadgeList);
//        System.out.println();
//        return usersReceivedBadgeList;
//    }

//    @PostMapping("/ownedlist")
//    public List<Badge> getUsersOwnedBadgesList(@RequestParam(name = "id") long userId) throws Exception {
//        final List<Badge> userOwnedBadgeList = mUserService.getUserOwnedBadges(userId);
//        return userOwnedBadgeList;
//    }
}
