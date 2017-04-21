package com.hedou.services.search.impl;

import com.hedou.entity.Course;
import com.hedou.services.common.impl.CommServiceImpl;
import com.hedou.services.search.ISearchService;
import com.hedou.vo.CourseVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by youngtree on 2017/4/20.
 */
@Service(value = "searchService")
public class SearchService extends CommServiceImpl implements ISearchService {
    @Override
    public List<CourseVo> getCourse(String wd, int page) throws Exception {
        List<CourseVo>reListVo=new ArrayList<>();
        if(!(wd.length()>0)){ return reListVo;}
        String sql="select * from Course where c_name like ? or c_excerpt like ? ";
        List<Map<String,Object>>reList=baseDAO.findBySQLForMap(sql, new Object[]{"%"+wd+"%","%"+wd+"%"},page,10);
        for(Map<String,Object> m:reList){
            CourseVo cv=new CourseVo(Long.parseLong(m.get("c_id").toString()),m.get("c_name").toString(),m.get("c_pic").toString(),m.get("c_excerpt").toString());
            reListVo.add(cv);
        }
        return reListVo;
    }
}
