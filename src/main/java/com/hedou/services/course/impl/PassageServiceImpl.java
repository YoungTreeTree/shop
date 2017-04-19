package com.hedou.services.course.impl;

import com.hedou.entity.*;
import com.hedou.services.common.impl.CommServiceImpl;
import com.hedou.services.course.IPassageService;
import com.hedou.vo.CommentVo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

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
    public List<CommentVo> getPassageComment(long passageId, int page) throws Exception {
        if (baseDAO.findById(passageId, Passage.class) == null) return null;
        List<Comment> comments = baseDAO.findByProperty("PId", passageId, Comment.class, page, 10);
        List<Long> userIds = comments.stream().map(Comment::getUId).collect(Collectors.toList());
        List<User> users = baseDAO.findByIds("UId", userIds, User.class);
        List<CommentVo> commentVos = comments.stream().map(CommentVo::ConvertFromComment).collect(Collectors.toList());
        commentVos.forEach(x -> {
            List<User> newUsers = users.stream().filter(y -> y.getUId() == x.getUId()).collect(Collectors.toList());
            x.setUser(newUsers.size() > 0 ? newUsers.get(0) : new User());
        });
        return commentVos;
    }

    @Override
    public int addPassageComment(long userId, long passageId, String content) throws Exception {
        if (baseDAO.findById(passageId, Passage.class) == null) return 1;
        Comment comment = new Comment(userId, passageId, content, new Timestamp((new Date()).getTime()));
        baseDAO.save(comment);
        return 0;
    }
}
