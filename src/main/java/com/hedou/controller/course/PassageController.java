package com.hedou.controller.course;

import com.hedou.controller.base.BaseController;
import com.hedou.entity.NoteForPassage;
import com.hedou.json.BaseJson;
import com.hedou.services.course.IPassageService;
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
public class PassageController extends BaseController{

    @Resource
    private IPassageService passageService;

    private BaseJson queryJson = new BaseJson();

    @ResponseBody
    @RequestMapping(value = "/note", method = RequestMethod.GET)
    public BaseJson getPocketsHis(@RequestParam("p_id") long pId) throws Exception {
        queryJson = new BaseJson();
        setUserSession(1);
        long userId=getUserSession();
        NoteForPassage result = passageService.getPassageNote(pId,userId);
        if (result!=null) {
            queryJson.setObj(result);
            queryJson.setErrno(0);
        } else {
            queryJson.setErrno(1);
            queryJson.setErrmsg("暂无相应笔记数据！");
        }
        return queryJson;
    }
}
