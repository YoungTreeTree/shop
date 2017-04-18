package com.hedou.services.course;

import com.hedou.entity.NoteForPassage;
import com.hedou.services.common.ICommService;

import java.util.List;

/**
 * Created by cblin on 2017/4/18.
 */
public interface IPassageService extends ICommService {

    public NoteForPassage getPassageNote(long userId, long passageId) throws Exception;
}