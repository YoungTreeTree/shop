package com.hedou.services.course.impl;

import com.hedou.entity.Course;
import com.hedou.entity.User;
import com.hedou.entity.UserCourseRelation;
import com.hedou.entity.UserCourseRelationId;
import com.hedou.json.BaseJson;
import com.hedou.services.common.impl.CommServiceImpl;
import com.hedou.services.course.ICourseService;
import com.hedou.services.search.ISearchService;
import com.hedou.vo.CourseVo;
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
