package com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces;

import com.badging.spinnerbadger.SpinnerBadger.Models.Tag;

public interface TagService {
    Tag save(Tag tag);
    Tag getTagByTitle(String title);
}
