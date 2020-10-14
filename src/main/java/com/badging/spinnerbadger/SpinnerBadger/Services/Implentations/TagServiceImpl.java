package com.badging.spinnerbadger.SpinnerBadger.Services.Implentations;

import com.badging.spinnerbadger.SpinnerBadger.Models.Tag;
import com.badging.spinnerbadger.SpinnerBadger.Repository.TagRepo;
import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepo mTagRepo;

    @Override
    public Tag save(Tag tag) {
        return mTagRepo.saveAndFlush(tag);
    }

    @Override
    public Tag getTagByTitle(String title) {
        return mTagRepo.findByTitle(title).orElse(new Tag());
    }
}
