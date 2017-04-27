package com.shop.controller.search;

import com.shop.controller.base.BaseController;
import com.shop.json.BaseJson;
import com.shop.services.search.ISearchService;
import com.shop.vo.CourseVo;
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
    private ISearchService searchService;
    private BaseJson queryJson = new BaseJson();

    @ResponseBody
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public BaseJson getPassageNote(@RequestParam("wd") String wd) throws Exception {
        queryJson = new BaseJson();
        queryJson.setErrmsg("success");
        String page_p=getHttpRequest().getParameter("page");
        int page=1;
        if(page_p.length()>0){
             page=Integer.parseInt(page_p);
        }
        List<CourseVo> result = searchService.getCourse(wd,page-1);
        if(result.size()<=0){
            result=null;
            queryJson.setErrno(1);
        }
        return processServiceResult(queryJson, result, "没有找到相关课程！");
    }


}
