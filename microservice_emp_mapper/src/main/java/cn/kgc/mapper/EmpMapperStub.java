package cn.kgc.mapper;

import cn.kgc.entity.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface EmpMapperStub extends BaseMapper<Emp> {
    List<Emp> selectAllEmp();
    Emp selectEmpById(Integer id);
    boolean updateEmpById(Emp emp);
    boolean insertEmp(Emp emp);

}
