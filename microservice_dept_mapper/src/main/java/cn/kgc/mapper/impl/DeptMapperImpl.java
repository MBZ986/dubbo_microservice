package cn.kgc.mapper.impl;

import cn.kgc.entity.Department;
import cn.kgc.mapper.DeptMapper;
import cn.kgc.mapper.DeptMapperStub;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service(interfaceClass = DeptMapper.class)
public class DeptMapperImpl implements DeptMapper {

    @Autowired
    private DeptMapperStub deptMapperStub;

    @Override
    public List<Department> selectAll() {
        return deptMapperStub.selectList(new QueryWrapper<>());
    }

    @Override
    public Department selectById(Integer id) {
        return deptMapperStub.selectById(id);
    }

    @Override
    public boolean delete(Integer id) {
        return deptMapperStub.deleteById(id) > 0;
    }

    @Override
    public boolean insert(Department department) {
        System.out.println(department);
        boolean res = deptMapperStub.insert(department) > 0;
        System.out.println(res);
        return res;
    }

    @Override
    public boolean modify(Department department) {
        return deptMapperStub.updateById(department) > 0;
    }
}
