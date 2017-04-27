package com.shop.services.user.impl;

import com.shop.entity.*;
import com.shop.services.common.impl.CommServiceImpl;
import com.shop.services.user.IUserService;
import com.shop.vo.CourseVo;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by a3578 on 2017/4/22.
 */
@Service(value = "userService")
public class UserServiceImpl extends CommServiceImpl implements IUserService {
    @Override
    public List<CourseVo> getCourseByPage(long u_id, int page) throws Exception {
        String sql = "select * from Course natural join User_Course_Relation where u_id = ?";
        List<Map<String,Object>> courses = baseDAO.findBySQLForMap(sql, new Object[]{u_id}, page, 10);
        List<CourseVo> result = new ArrayList<>();
        for (Map<String,Object> course : courses)
        {
            CourseVo courseVo=new CourseVo(Long.parseLong(course.get("c_id").toString()),course.get("c_name").toString(),course.get("c_pic").toString(),course.get("c_excerpt").toString());
            result.add(courseVo);
        }
        return result;
    }

    @Override
    public int updateUser(long u_id,String u_name, String u_signature, String u_full_name, String u_school, String u_grade){
        try {
            List<User> users = baseDAO.findByProperty("UId", u_id, User.class);
            User user;
            if (users.size() > 0) {
                user = users.get(0);
                user.setUName(u_name);
                user.setUFullName(u_full_name);
                user.setUSignature(u_signature);
                user.setUSchool(u_school);
                user.setUGrade(u_grade);
                baseDAO.save(user);
                return 0;
            } else {
                return -1;
            }
        } catch (Exception ex) {
            return -1;
        }
    }
}
