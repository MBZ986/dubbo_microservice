package cn.kgc.mapper;

import cn.kgc.entity.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> selectAll();
    Emp selectById(Integer id);
    boolean delete(Integer id);
    boolean insert(Emp emp);
    boolean modify(Emp emp);
}
