package com.shop.services.course;

import com.shop.entity.NoteForPassage;
import com.shop.services.common.ICommService;
import com.shop.vo.CommentVo;

import java.util.List;

/**
 * Created by cblin on 2017/4/18.
 */
public interface IPassageService extends ICommService {

    public NoteForPassage getPassageNote(long userId, long passageId) throws Exception;

    public int saveOrUpdatePassageNote(long userId, long passageId, String noteContent) throws Exception;

    public List<CommentVo> getPassageComment(long passageId, int page) throws Exception;

    public int addPassageComment(long userId, long passageId, String content) throws Exception;

}
