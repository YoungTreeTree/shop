package com.hedou.services.course.impl;

import com.hedou.entity.Comment;
import com.hedou.entity.NoteForPassage;
import com.hedou.entity.NoteForPassageId;
import com.hedou.entity.Passage;
import com.hedou.services.common.impl.CommServiceImpl;
import com.hedou.services.course.IPassageService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cblin on 2017/4/18.
 */
@Service(value = "passageService")
public class PassageServiceImpl extends CommServiceImpl implements IPassageService {

    @Override
    public NoteForPassage getPassageNote(long userId, long passageId) throws Exception {
        NoteForPassageId id = new NoteForPassageId(passageId, userId);
        return baseDAO.findById(id, NoteForPassage.class);
    }

    /**
     * @param userId
     * @param passageId
     * @param noteContent
     * @return 0成功，1无相应文章
     * @throws Exception
     */
    @Override
    public int saveOrUpdatePassageNote(long userId, long passageId, String noteContent) throws Exception {
        if (baseDAO.findById(passageId, Passage.class) == null) return 1;
        NoteForPassageId id = new NoteForPassageId(passageId, userId);
        NoteForPassage noteForPassage = baseDAO.findById(id, NoteForPassage.class);
        if (noteForPassage != null) {
            noteForPassage.setNoteContent(noteContent);
            noteForPassage.setNoteDate(new Timestamp((new Date()).getTime()));
            baseDAO.update(noteForPassage);
        } else {
            NoteForPassage newNoteForPassage = new NoteForPassage(id, noteContent, new Timestamp((new Date()).getTime()));
            baseDAO.save(newNoteForPassage);
        }
        return 0;
    }

    @Override
    public int addPassageComment(long userId, long passageId, String content) throws Exception {
        if (baseDAO.findById(passageId, Passage.class) == null) return 1;
        Map<String, Object> propertyNameValueMap = new HashMap<>();
        propertyNameValueMap.put("UId", userId);
        propertyNameValueMap.put("PId", passageId);
        List<Comment> comments = baseDAO.findByPropertys(propertyNameValueMap, Comment.class);
        if(comments.size()>0){
            Comment comment=comments.get(0);
        }
        Comment comment = new Comment(userId, passageId, content, new Timestamp((new Date()).getTime()));
        baseDAO.save(comment);
        return 0;
    }
}
