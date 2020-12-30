package cn.kgc.controller;

import cn.kgc.constant.ResponseStatus;
import cn.kgc.dto.ResponseMsg;
import cn.kgc.entity.Department;
import cn.kgc.entity.Emp;
import cn.kgc.service.DeptService;
import cn.kgc.service.EmpService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@CrossOrigin
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Reference(check = false, loadbalance = "RoundRobin", timeout = 7000)
    private EmpService empService;

    @GetMapping("/queryAll")
    public ResponseMsg queryAll() {
        ResponseMsg responseMsg = new ResponseMsg();
        List<Emp> departments = empService.queryAll();
        responseMsg.setData(departments);
        return responseMsg;
    }

    @GetMapping("/queryById/{id}")
    public ResponseMsg queryById(@PathVariable("id") Integer id) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setData(empService.queryById(id));
        return responseMsg;
    }

    @DeleteMapping("/remove/{id}")
    public ResponseMsg remove(@PathVariable("id") Integer id) {
        ResponseMsg responseMsg = new ResponseMsg();
        if (empService.remove(id)) {
            responseMsg.setCode(ResponseStatus.SUCCESS.getCode());
            responseMsg.setMsg("删除雇员成功");
        } else {
            responseMsg.setCode(ResponseStatus.FAIL.getCode());
            responseMsg.setMsg("删除雇员失败");
        }
        return responseMsg;
    }

    @PostMapping("/insert")
    public ResponseMsg insert(@RequestBody Emp emp) {
        ResponseMsg responseMsg = new ResponseMsg();
        if (empService.insert(emp)) {
            responseMsg.setCode(ResponseStatus.SUCCESS.getCode());
            responseMsg.setMsg("添加雇员成功");
        } else {
            responseMsg.setCode(ResponseStatus.FAIL.getCode());
            responseMsg.setMsg("添加雇员失败");
        }
        return responseMsg;
    }

    @PutMapping("/modify")
    public ResponseMsg modify(@RequestBody Emp emp) {
        ResponseMsg responseMsg = new ResponseMsg();
        if (emp.getId() != null) {
            if (empService.modify(emp)) {
                responseMsg.setCode(ResponseStatus.SUCCESS.getCode());
                responseMsg.setMsg("修改雇员成功");
            } else {
                responseMsg.setCode(ResponseStatus.FAIL.getCode());
                responseMsg.setMsg("修改雇员失败");
            }
        } else {
            responseMsg.setCode(ResponseStatus.FAIL.getCode());
            responseMsg.setMsg("提交数据异常");
        }

        return responseMsg;
    }
}
