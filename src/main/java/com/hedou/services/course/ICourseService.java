package com.hedou.services.course;

import com.hedou.json.BaseJson;
import com.hedou.services.common.ICommService;
import com.hedou.vo.CourseVo;

import java.util.List;

/**
 * Created by youngtree on 2017/4/20.
 */
public interface ICourseService extends ICommService {
    public List<CourseVo> getCourseByCidAndPage(long cat_id , int page) throws Exception;

    public BaseJson attendCourse(long c_id , long u_id) throws Exception;
}
