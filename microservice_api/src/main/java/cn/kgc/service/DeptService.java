package cn.kgc.service;

import cn.kgc.entity.Department;

import java.util.List;

public interface DeptService {
    List<Department> queryAll();
    Department queryById(Integer id);
    boolean remove(Integer id);
    boolean insert(Department department);
    boolean modify(Department department);
    void info();
}
