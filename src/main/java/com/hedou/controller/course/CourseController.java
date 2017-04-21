package com.hedou.controller.course;

import com.hedou.controller.base.BaseController;
import com.hedou.entity.NoteForPassage;
import com.hedou.json.BaseJson;
import com.hedou.services.course.ICourseService;
import com.hedou.services.course.IPassageService;
import com.hedou.services.course.impl.CourseServiceImpl;
import com.hedou.vo.CommentVo;
import com.hedou.vo.CourseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by youngtree on 2017/4/20.
 */
@Controller
@RequestMapping(value = "/course")
public class CourseController extends BaseController {

    @Resource
    private ICourseService courseService;

    private BaseJson queryJson = new BaseJson();

    @ResponseBody
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public BaseJson getCourseByCidAndPage(@RequestParam("cat_id") long cat_id) throws Exception {
        queryJson = new BaseJson();
        queryJson.setErrmsg("success");
        String page_p=getHttpRequest().getParameter("page");
        int page=1;
        if(page_p!=null&&page_p.length()>0){
            page=Integer.parseInt(page_p);
        }
        List<CourseVo> reList=courseService.getCourseByCidAndPage(cat_id,page-1);
        if(reList.size()<=0){
            reList=null;
            queryJson.setErrno(1);
        }
        return processServiceResult(queryJson, reList, "暂无相应课程！");
    }
    @ResponseBody
    @RequestMapping(value = "/attend", method = RequestMethod.GET)
    public BaseJson attendCourse(@RequestParam("c_id") long c_id) throws Exception {
        queryJson = new BaseJson();

        boolean is_login = false;
        long u_id=-2;
        long u_id_p=1;
        try {
            is_login = (boolean) getSessionAttribute("is_login");
            u_id = (long) getSessionAttribute("u_id");
        } catch (Exception e) {
        }
        System.out.println(is_login+"  "+u_id);
        if(is_login==false||u_id==-1){
            queryJson.setErrno(1);
            return processServiceResult(queryJson, null, "加入课程请先登录！");
        }
        queryJson = courseService.attendCourse( c_id, u_id);
        String result=null;
        if(queryJson.getErrno()==0){
            result="";
            queryJson.setErrmsg("success");
        }
        return processServiceResult(queryJson, result, queryJson.getErrmsg());

    }

}
