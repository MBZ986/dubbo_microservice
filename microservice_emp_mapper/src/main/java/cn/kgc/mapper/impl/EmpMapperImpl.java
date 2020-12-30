package cn.kgc.mapper.impl;

import cn.kgc.mapper.EmpMapperStub;
import cn.kgc.entity.Emp;
import cn.kgc.mapper.EmpMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class EmpMapperImpl implements EmpMapper {

    @Autowired
    private EmpMapperStub empMapperStub;

    @Override
    public List<Emp> selectAll() {
        return empMapperStub.selectAllEmp();
    }

    @Override
    public Emp selectById(Integer id) {
        return empMapperStub.selectEmpById(id);
    }

    @Override
    public boolean delete(Integer id) {
        return empMapperStub.deleteById(id) > 0;
    }

    @Override
    public boolean insert(Emp emp) {
        return empMapperStub.insertEmp(emp);
    }

    @Override
    public boolean modify(Emp emp) {
        return empMapperStub.updateEmpById(emp);
    }
}
