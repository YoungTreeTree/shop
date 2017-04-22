package com.hedou.controller.user;


import com.hedou.controller.base.BaseController;
import com.hedou.json.BaseJson;
import com.hedou.services.user.IUserService;
import com.hedou.vo.CourseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by a3578 on 2017/4/22.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
    @Resource
    private IUserService userService;

    private BaseJson queryJson = new BaseJson();

    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public BaseJson updateUserInfo() throws Exception {
        queryJson = new BaseJson();
        queryJson.setErrno(1);
        long u_id = getUserSession();
        String u_name = getHttpRequest().getParameter("u_name");
        String u_signature = getHttpRequest().getParameter("u_signature");
        String u_full_name = getHttpRequest().getParameter("u_full_name");
        String u_school = getHttpRequest().getParameter("u_school");
        String u_grade = getHttpRequest().getParameter("u_grade");
        if(u_name==null||u_signature==null||u_full_name==null||u_school==null||u_grade==null
                ||u_name==""||u_signature==""||u_full_name==""||u_school==""||u_grade==""){
            queryJson.setErrmsg("invalid parameter");
        }
        int result = userService.updateUser(u_id,u_name,u_signature,u_full_name,u_school,u_grade);
        if(result==0){
            queryJson.setErrno(0);
            queryJson.setErrmsg("success");
        }else {
            queryJson.setErrmsg("unknown error");
        }
        return queryJson;
    }

    @ResponseBody
    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public BaseJson getMyCourse(@RequestParam(value = "page", defaultValue = "0") int page) throws Exception {
        queryJson = new BaseJson();
        queryJson.setErrmsg("success");
        long u_id = getUserSession();
        List<CourseVo> courses = userService.getCourseByPage(u_id, page - 1);
        if (courses.size() <= 0) {
            courses = null;
        }
        return processServiceResult(queryJson, courses, "no course");
    }
}
