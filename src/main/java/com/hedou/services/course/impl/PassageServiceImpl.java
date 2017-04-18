package com.hedou.services.course.impl;

import com.hedou.entity.NoteForPassage;
import com.hedou.entity.NoteForPassageId;
import com.hedou.services.common.impl.CommServiceImpl;
import com.hedou.services.course.IPassageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cblin on 2017/4/18.
 */
@Service(value = "passageService")
public class PassageServiceImpl extends CommServiceImpl implements IPassageService{

    @Override
    public NoteForPassage getPassageNote(long userId, long passageId) throws Exception {
        NoteForPassageId id=new NoteForPassageId(passageId,userId);
        return baseDAO.findById(id, NoteForPassage.class);
    }
}
