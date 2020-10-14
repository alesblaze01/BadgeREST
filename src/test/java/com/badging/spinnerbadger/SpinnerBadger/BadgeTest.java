package com.badging.spinnerbadger.SpinnerBadger;

import com.badging.spinnerbadger.SpinnerBadger.Controllers.BadgeController;
import com.badging.spinnerbadger.SpinnerBadger.Models.Badge;
import com.badging.spinnerbadger.SpinnerBadger.Models.Skill;
import com.badging.spinnerbadger.SpinnerBadger.Models.Tag;
import com.badging.spinnerbadger.SpinnerBadger.Models.User;
import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.BadgeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BadgeTest {
    @Autowired
    private MockMvc mMockMvc;
    @Autowired
    private BadgeController mBadgeController;

    @Test
    public void saveBadges() throws Exception {
        mBadgeController = Mockito.mock(BadgeController.class);
        Badge badge1 = new Badge();
        User user1 = new User();
        user1.setUserName("User1");
        user1.setFullName("FullName1");
        user1.setSalt("salt1");
        getBadge(user1, badge1, "Desc1", "Logo1", "Name1", Arrays.asList(new Tag("Tag1"),
                new Tag("Tag2")), Arrays.asList(new Skill("Skill1"), new Skill("Skill2")));

        when(mBadgeController.getAllBadge(0,2)).thenReturn(Arrays.asList(badge1));

        ObjectMapper objectMapper = new ObjectMapper();
        final String jsonString = objectMapper.writeValueAsString(badge1);

        mMockMvc.perform(get("/badge/all?pagenumber=0&pagesize=2"))
//                .andReturn().getResponse().getContentAsString();
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(content().encoding("ISO-8859-1"))
                .andExpect(jsonPath("$").isArray())
        //                .andExpect(content().json(jsonString))
                ;
    }

    private void getBadge(User user1, Badge badge1, String desc1, String logo1,
                           String badge12, List<Tag> tags1 , List<Skill> skills) {
        badge1.setDescription(desc1);
        badge1.setLogo(logo1);
        badge1.setName(badge12);
        badge1.setIssuer(user1);
        badge1.setTagList(tags1);
        badge1.setSkillList(skills);
    }
}
