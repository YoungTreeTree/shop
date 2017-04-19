package com.hedou.daos;

import java.util.List;
import java.util.Map;

/**
 * Created by bill on 2016/12/7.
 */
public interface BaseDAO {

    public void save(Object transientInstance);

    public void delete(Object persistentInstance);

    public void update(Object persistentInstance);

    public <T> T findById(java.lang.Object id, Class<T> cls);

    public List findAll(Class cls);

    public List findByProperty(String propertyName, Object value, Class cls);

    public List findByPropertys(Map<String, Object> propertyNameValueMap, Class cls);

    public List<Map<String, Object>> findBySQLForMap(final String sql, final Object[] values);

    public List<Map<String, Object>> findBySQLForMap(String sql, Object[] values, int currentPage, int pageSize);

    public int executeSQL(final String sql, final Object[] values);

    public int executeSQL(final String sql);

    public List findBySQL(final String sql, final Object[] values);

    public List findByPageForSQL(final String sql, final Object[] values, final int offset, final int pageSize);

    public List findBySQLForVO(final String sql, final Class classes, final Object[] values);

    public List findBySQLForVO(final String sql, final Class classes, final Object[] values, final int offset, final int pageSize);

    public void flush();

    public void clear();


}
