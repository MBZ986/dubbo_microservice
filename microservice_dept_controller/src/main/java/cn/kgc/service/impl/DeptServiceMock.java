package cn.kgc.service.impl;

import cn.kgc.entity.Department;
import cn.kgc.service.DeptService;

import java.util.ArrayList;
import java.util.List;

public class DeptServiceMock implements DeptService {
    @Override
    public List<Department> queryAll() {
        List<Department> deptList = new ArrayList<>();
        Department department = new Department();
        department.setId(01);
        department.setDepartmentName("服务降级");
        deptList.add(department);
        return deptList;
    }

    @Override
    public Department queryById(Integer id) {
        Department department = new Department();
        department.setId(01);
        department.setDepartmentName("服务降级");
        return department;
    }

    @Override
    public boolean remove(Integer id) {
        System.out.println("服务降级");
        return false;
    }

    @Override
    public boolean insert(Department department) {
        System.out.println("服务降级");
        return false;
    }

    @Override
    public boolean modify(Department department) {
        System.out.println("服务降级");
        return false;
    }

    @Override
    public void info() {

    }
}
