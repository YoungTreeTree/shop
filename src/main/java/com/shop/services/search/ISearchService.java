package com.shop.services.search;

import com.shop.services.common.ICommService;
import com.shop.vo.CourseVo;

import java.util.List;

/**
 * Created by youngtree on 2017/4/20.
 */
public interface ISearchService extends ICommService {
    public List<CourseVo> getCourse(String wd, int page) throws Exception;
}
