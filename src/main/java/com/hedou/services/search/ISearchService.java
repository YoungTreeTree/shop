package com.hedou.services.search;

import com.hedou.services.common.ICommService;
import com.hedou.vo.CourseVo;

import java.util.List;

/**
 * Created by youngtree on 2017/4/20.
 */
public interface ISearchService extends ICommService {
    public List<CourseVo> getCourse(String wd, int page) throws Exception;
}
