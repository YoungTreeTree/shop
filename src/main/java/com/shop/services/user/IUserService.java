package com.shop.services.user;

import com.shop.services.common.ICommService;
import com.shop.vo.CourseVo;

import java.util.List;

/**
 * Created by a3578 on 2017/4/22.
 */
public interface IUserService extends ICommService {
    public List<CourseVo> getCourseByPage(long u_id, int page) throws Exception;

    public int updateUser(long u_id,String u_name, String u_signature, String u_full_name, String u_school, String u_grade);
}
