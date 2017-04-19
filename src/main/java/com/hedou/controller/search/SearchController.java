package com.hedou.controller.search;

import com.hedou.controller.base.BaseController;
import com.hedou.json.BaseJson;
import com.hedou.services.search.impl.SearchService;
import com.hedou.vo.CourseVo;
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
@RequestMapping(value = "/search")
public class SearchController extends BaseController {

    @Resource
    private SearchService searchService;
    private BaseJson queryJson = new BaseJson();

    @ResponseBody
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public BaseJson getPassageNote(@RequestParam("wd") String wd, @RequestParam("page") int page) throws Exception {
        queryJson = new BaseJson();
        System.out.println(wd+"   "+page);
        List<CourseVo> result = searchService.getCourse(wd,page-1);
        if(result.size()<=0){
            result=null;
            queryJson.setErrno(1);
        }
        return processServiceResult(queryJson, result, "没有找到相关课程！");
    }


}