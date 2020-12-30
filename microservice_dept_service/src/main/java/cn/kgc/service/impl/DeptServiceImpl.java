package cn.kgc.service.impl;

import cn.kgc.entity.Department;
import cn.kgc.mapper.DeptMapper;
import cn.kgc.service.DeptService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {

    @Reference(check = false)
    private DeptMapper deptMapper;

    @Override
    public List<Department> queryAll() {
        return deptMapper.selectAll();
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
        System.out.println("调用DeptService");
        RpcContext rpcContext = RpcContext.getContext();
        String remoteHost = rpcContext.getRemoteHost();
        int remotePort = rpcContext.getRemotePort();
        System.out.println("RPC最后一次提供的最后一次服务地址："+remoteHost+":"+remotePort);

    }
}
