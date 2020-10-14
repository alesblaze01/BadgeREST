//package com.badging.spinnerbadger.SpinnerBadger;
//
//import com.badging.spinnerbadger.SpinnerBadger.Models.Badge;
//import com.badging.spinnerbadger.SpinnerBadger.Models.Skill;
//import com.badging.spinnerbadger.SpinnerBadger.Models.Tag;
//import com.badging.spinnerbadger.SpinnerBadger.Models.User;
//import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.BadgeService;
//import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.SkillService;
//import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.TagService;
//import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import javax.transaction.Transactional;
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class StartupExecutor implements CommandLineRunner {
//    @Autowired
//    private BadgeService mBadgeService;
//    @Autowired
//    private UserService mUserService;
//    @Autowired
//    private TagService mTagService;
//    @Autowired
//    private SkillService mSkillService;
//
//    @Transactional
//    @Override
//    public void run(String... args) throws Exception {
//        //TODO:: issuer cannot issue badge to itself
//        final User user1 = new User();
//        final User user1Saved = getUser(user1, "User1 FullName", "salt1", "User1 UserName");
//
//        final User user2 = new User();
//        final User user2Saved = getUser(user2, "User2 FullName", "salt2", "User2 UserName");
//
//        Tag tag1 = new Tag();
//        tag1.setTitle("Tag1");
//        tag1 = mTagService.save(tag1);
//
//        Tag tag2 = new Tag();
//        tag2.setTitle("Tag2");
//        tag2 = mTagService.save(tag2);
//
//        final List<Tag> tags1 = Arrays.asList(tag1,tag2);
//
//        Tag tag3 = new Tag();
//        tag3.setTitle("Tag3");
//        tag3 = mTagService.save(tag3);
//
//        Tag tag4 = new Tag();
//        tag4.setTitle("Tag4");
//        tag4 = mTagService.save(tag4);
//
//        final List<Tag> tags2 = Arrays.asList(tag3, tag4);
//
//        Skill skill1 = new Skill("Android Developer");
//        Skill skill2 = new Skill("Backend Developer");
//        Skill skill3 = new Skill("Frontend Developer");
//        Skill skill4 = new Skill("PHP Developer");
////        mSkillService.saveAll(Arrays.asList(skill1,skill2,skill3,skill4));
//        skill1 = mSkillService.save(skill1);
//        skill2 = mSkillService.save(skill2);
//        skill3 = mSkillService.save(skill3);
//        skill4 = mSkillService.save(skill4);
//
//        final List<Skill> list1 = Arrays.asList(skill1,skill2);
//        final List<Skill> list2 = Arrays.asList(skill3,skill4);
//        final List<Skill> list3 = Arrays.asList(skill1, skill3);
//
//        Badge badge1 = new Badge();
//        final Badge badge1Saved = getBadge(user1, badge1, "Desc1", "Logo1", "Badge1" ,
//                tags1 , list1);
//
//        Badge badge2 = new Badge();
//        final Badge badge2Saved = getBadge(user2, badge2, "Desc2", "Logo2", "Badge2",
//                tags1 , list2);
//
//        Badge badge3 = new Badge();
//        final Badge badge3Saved = getBadge(user1, badge3, "Desc3", "Logo3", "Badge3",
//                tags2 , list3);
//    }
//
//    private Badge getBadge(User user1, Badge badge1, String desc1, String logo1,
//                           String badge12, List<Tag> tags1 , List<Skill> skills) {
//        badge1.setDescription(desc1);
//        badge1.setLogo(logo1);
//        badge1.setName(badge12);
//        badge1.setIssuer(user1);
//        badge1.setTagList(tags1);
//        badge1.setSkillList(skills);
//        return saveBadge(badge1);
//    }
//
//    private Badge saveBadge(Badge badge1) {
//        return mBadgeService.save(badge1);
//    }
//
//    private User getUser(User user1, String fullName, String salt, String userName) {
//        user1.setFullName(fullName);
//        user1.setSalt(salt);
//        user1.setUserName(userName);
//        return saveUser(user1);
//    }
//
//    private User saveUser(User user1) {
//        return mUserService.save(user1);
//    }
//
//    private boolean checkEquality(User user , User userSaved) {
//        return user.equals(userSaved);
//    }
//    private boolean checkEquality(Badge badge , Badge badgeSaved) {
//        return badge.equals(badgeSaved);
//    }
//
//    private void printSuccess(String string){
//        System.err.println(string + " saved successfully");
//    }
//}
