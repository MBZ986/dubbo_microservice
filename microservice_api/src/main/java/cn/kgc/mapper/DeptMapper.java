package cn.kgc.mapper;

import cn.kgc.entity.Department;

import java.util.List;

public interface DeptMapper {
    List<Department> selectAll();
    Department selectById(Integer id);
    boolean delete(Integer id);
    boolean insert(Department department);
    boolean modify(Department department);
}
