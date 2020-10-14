package com.badging.spinnerbadger.SpinnerBadger.Controllers;

import com.badging.spinnerbadger.SpinnerBadger.Models.Tag;
import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tag")
public class TagController {
    @Autowired
    private TagService mTagService;

    @PostMapping("save")
    public Tag save(@RequestParam(name = "tag_title") String title) {
        Tag tag = new Tag();
        tag.setTitle(title);
        return mTagService.save(tag);
    }
}
