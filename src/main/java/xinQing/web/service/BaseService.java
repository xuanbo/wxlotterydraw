package xinQing.web.service;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xinQing on 2016/9/27.
 */
public interface BaseService<T, ID extends Serializable> {

    /**
     * 插入
     *
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 更新
     *
     * @param t
     * @return
     */
    int update(T t);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(ID id);

    /**
     * 查询所有记录
     * @return
     */
    List<T> selectAll();

    /**
     * 分页查询
     *
     * @param current
     * @param size
     * @return
     */
    PageInfo<T> getByPage(Integer current, Integer size);

    /**
     * 查询
     *
     * @param t
     * @return
     */
    T selectOne(T t);

}
