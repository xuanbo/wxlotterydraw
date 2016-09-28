package xinQing.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import xinQing.web.service.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xinQing on 2016/9/27.
 */
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    @Autowired
    private Mapper<T> mapper;

    @Override
    public int insert(T t) {
        return mapper.insert(t);
    }

    @Override
    public int update(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    @Override
    public int delete(ID id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public PageInfo<T> getByPage(Integer current, Integer size) {
        PageHelper.startPage(current, size, "id desc");
        return new PageInfo<>(mapper.selectAll());
    }

    @Override
    public T selectOne(T t) {
        return mapper.selectOne(t);
    }
}
