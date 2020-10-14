package com.badging.spinnerbadger.SpinnerBadger.Repository;

import com.badging.spinnerbadger.SpinnerBadger.Models.Badge;
import com.badging.spinnerbadger.SpinnerBadger.Models.BadgeDTO;
import com.badging.spinnerbadger.SpinnerBadger.Models.Skill;
import com.badging.spinnerbadger.SpinnerBadger.Models.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BadgeRepo extends PagingAndSortingRepository<Badge,Long> {
    @Query("SELECT new com.badging.spinnerbadger.SpinnerBadger.Models.BadgeDTO(b.mId , " +
            "b.mName , b.mDescription , b.mLogo , b" +
            ".mIssuer" +
            ".mFullName , b.mIssuer.mUserName , b.mIssuer.mId)" +
            "FROM Badge b WHERE b.mIssuer.mId = " +
            ":userId")
    List<BadgeDTO> findBadgesUserOwns(@Param(value = "userId") long userId ,
                                      Pageable pageable);

//    @Query("SELECT * FROM Badge b WHERE b.tagIds.contains(title)")
//    Optional<List<Badge>> findBadgesByTagTitle(Tag title , Pageable pageable);

    @Query("SELECT b from Badge b WHERE :tag MEMBER OF b.mTagList")
    Optional<List<Badge>> findBadgeByTag(@Param(value = "tag") Tag tag);

    @Query("SELECT b from Badge b WHERE :skill MEMBER OF b.mSkillList")
    Optional<List<Badge>> findBadgeBySkill(@Param(value="skill")Skill skill);
}
