package cn.kgc.service.impl;

import ch.qos.logback.core.util.TimeUtil;
import cn.kgc.entity.Department;
import cn.kgc.mapper.DeptMapper;
import cn.kgc.service.DeptService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DeptServiceImpl implements DeptService {
    @Reference(check = false)
    private DeptMapper deptMapper;

    @Override
    public List<Department> queryAll() {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        List<Department> departments = deptMapper.selectAll();
        departments.add(new Department(999,"轮询"));
        return departments;
    }

    @Override
    public Department queryById(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override
    public boolean remove(Integer id) {
        return deptMapper.delete(id);
    }

    @Override
    public boolean insert(Department department) {
        boolean insert = deptMapper.insert(department);
        System.out.println("添加结果："+insert);
        return insert;
    }

    @Override
    public boolean modify(Department department) {
        return deptMapper.modify(department);
    }

    @Override
    public void info() {

    }
}
