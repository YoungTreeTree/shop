package com.shop.controller.course;

import com.shop.controller.base.BaseController;
import com.shop.entity.NoteForPassage;
import com.shop.json.BaseJson;
import com.shop.services.course.IPassageService;
import com.shop.vo.CommentVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cblin on 2017/4/18.
 */
@Controller
@RequestMapping(value = "/passage") 
public class PassageController extends BaseController {

    @Resource
    private IPassageService passageService;

    private BaseJson queryJson = new BaseJson();

    @ResponseBody
    @RequestMapping(value = "/note", method = RequestMethod.GET)
    public BaseJson getPassageNote(@RequestParam("p_id") long pId) throws Exception {
        queryJson = new BaseJson();
        setUserSession(1);
        long userId = getUserSession();
        NoteForPassage result = passageService.getPassageNote(userId, pId);
        return processServiceResult(queryJson, result, "暂无相应笔记数据！");
    }

    @ResponseBody
    @RequestMapping(value = "/note", method = RequestMethod.POST)
    public BaseJson saveOrUpdateNote(@RequestParam("p_id") long pId, @RequestParam("note_content") String noteContent) throws Exception {
        queryJson = new BaseJson();
        setUserSession(1);
        long userId = getUserSession();
        int result = passageService.saveOrUpdatePassageNote(userId, pId, noteContent);
        return processServiceResult(queryJson, result, "文章id不合法！");
    }

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public BaseJson getPassageComment(@RequestParam("p_id") long pId, @RequestParam(value = "page",defaultValue = "0") int page) throws Exception {
        queryJson = new BaseJson();
        List<CommentVo> result = passageService.getPassageComment(pId, page);
        return processServiceResult(queryJson, result, "文章id不合法！");
    }

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public BaseJson addPassageComment(@RequestParam("p_id") long pId, @RequestParam("content") String content) throws Exception {
        queryJson = new BaseJson();
        setUserSession(1);
        long userId = getUserSession();
        int result = passageService.addPassageComment(userId, pId, content);
        return processServiceResult(queryJson, result, "文章id不合法！");
    }


}
