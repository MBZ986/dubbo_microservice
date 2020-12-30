package cn.kgc.service;

import cn.kgc.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> queryAll();
    Emp queryById(Integer id);
    boolean remove(Integer id);
    boolean insert(Emp emp);
    boolean modify(Emp emp);
    void info();
}
