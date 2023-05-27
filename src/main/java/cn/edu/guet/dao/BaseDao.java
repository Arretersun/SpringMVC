package cn.edu.guet.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author liwei
 * @Date 2023/1/4 09:32
 * @Version 1.0
 */
public interface BaseDao<T> {

    int save(T t) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
    T getObjectById(Long id);
    List<T> getObject();


}
