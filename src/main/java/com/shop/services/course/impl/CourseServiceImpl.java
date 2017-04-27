package com.shop.services.course.impl;

import com.shop.entity.Course;
import com.shop.entity.User;
import com.shop.entity.UserCourseRelation;
import com.shop.entity.UserCourseRelationId;
import com.shop.json.BaseJson;
import com.shop.services.common.impl.CommServiceImpl;
import com.shop.services.course.ICourseService;
import com.shop.vo.CourseVo;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by youngtree on 2017/4/20.
 */
@Service(value = "courseService")
public class CourseServiceImpl extends CommServiceImpl implements ICourseService {
    @Override
    public List<CourseVo> getCourseByCidAndPage(long cat_id, int page) throws Exception {
        List<Course> reList = baseDAO.findByProperty("catId",cat_id,Course.class,page,8);
        List<CourseVo> reListVo=new ArrayList<>();
        for(Course c:reList){
            CourseVo cv=new CourseVo(c.getCId(),c.getCName(),c.getCPic(),c.getCExcerpt());
            reListVo.add(cv);
        }
        return reListVo;
    }

    @Override
    public BaseJson attendCourse(long c_id, long u_id) throws Exception {
        BaseJson queryJson=new BaseJson();
        if (baseDAO.findById(c_id, Course.class) == null){
            queryJson.setErrno(1);
            queryJson.setErrmsg("课程不存在！");
        }
        if (baseDAO.findById(u_id, User.class) == null){
            queryJson.setErrno(1);
            queryJson.setErrmsg("用户不存在！");
        }
        UserCourseRelationId id = new UserCourseRelationId (c_id,u_id);
        UserCourseRelation userCourseRelation= baseDAO.findById(id, UserCourseRelation.class);
        if (userCourseRelation != null) {
            queryJson.setErrno(1);
            queryJson.setErrmsg("课程已加入！");
        } else {
            baseDAO.save(new UserCourseRelation(id));
        }
        return queryJson;
    }
}
