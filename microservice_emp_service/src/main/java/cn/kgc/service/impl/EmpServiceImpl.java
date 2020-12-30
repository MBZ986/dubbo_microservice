package cn.kgc.service.impl;

import cn.kgc.entity.Emp;
import cn.kgc.mapper.EmpMapper;
import cn.kgc.service.EmpService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;

import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {

    @Reference
    private EmpMapper empMapper;

    @Override
    public List<Emp> queryAll() {
        return empMapper.selectAll();
    }

    @Override
    public Emp queryById(Integer id) {
        return empMapper.selectById(id);
    }

    @Override
    public boolean remove(Integer id) {
        return empMapper.delete(id);
    }

    @Override
    public boolean insert(Emp emp) {
        return empMapper.insert(emp);
    }

    @Override
    public boolean modify(Emp emp) {
        return empMapper.modify(emp);
    }

    @Override
    public void info() {

        System.out.println("调用EmpService");
        RpcContext rpcContext = RpcContext.getContext();
        String remoteHost = rpcContext.getRemoteHost();
        int remotePort = rpcContext.getRemotePort();
        System.out.println("RPC最后一次提供的最后一次服务地址："+remoteHost+":"+remotePort);
    }
}
