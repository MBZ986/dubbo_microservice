package cn.kgc.controller;

import cn.kgc.constant.ResponseStatus;
import cn.kgc.dto.ResponseMsg;
import cn.kgc.entity.Department;
import cn.kgc.service.DeptService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@CrossOrigin
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Reference(check = false)
    private DeptService deptService;

    @GetMapping("/queryAll")
    public ResponseMsg queryAll(){
        ResponseMsg responseMsg = new ResponseMsg();
        List<Department> departments = deptService.queryAll();
        responseMsg.setData(departments);
////        System.out.println("当前结果："+departments);
//        Future<Object> future = RpcContext.getContext().getFuture();
//        try {
//            Object o = future.get();
////            System.out.println("最终结果："+o);
//            responseMsg.setData(o);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        return responseMsg;
    }

    @GetMapping("/queryById/{id}")
    public ResponseMsg queryById(@PathVariable("id") Integer id){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setData(deptService.queryById(id));
        return responseMsg;
    }

    @DeleteMapping("/remove/{id}")
    public ResponseMsg remove(@PathVariable("id") Integer id){
        ResponseMsg responseMsg = new ResponseMsg();
        if(deptService.remove(id)){
            responseMsg.setCode(ResponseStatus.SUCCESS.getCode());
            responseMsg.setMsg("删除部门成功");
        }else{
            responseMsg.setCode(ResponseStatus.FAIL.getCode());
            responseMsg.setMsg("删除部门失败");
        }
        return responseMsg;
    }

    @PostMapping("/insert")
    public ResponseMsg insert(@RequestBody Department department){
        ResponseMsg responseMsg = new ResponseMsg();
        boolean insert = deptService.insert(department);
        System.out.println("添加结果："+insert);
        if(insert){
            responseMsg.setCode(ResponseStatus.SUCCESS.getCode());
            responseMsg.setMsg("添加部门成功");
        }else{
            responseMsg.setCode(ResponseStatus.FAIL.getCode());
            responseMsg.setMsg("添加部门失败");
        }
        return responseMsg;
    }

    @PutMapping("/modify")
    public ResponseMsg modify(@RequestBody Department department){
        ResponseMsg responseMsg = new ResponseMsg();
        if(department.getId()!=null){
            if(deptService.modify(department)){
                responseMsg.setCode(ResponseStatus.SUCCESS.getCode());
                responseMsg.setMsg("修改部门成功");
            }else{
                responseMsg.setCode(ResponseStatus.FAIL.getCode());
                responseMsg.setMsg("修改部门失败");
            }
        }else{
            responseMsg.setCode(ResponseStatus.FAIL.getCode());
            responseMsg.setMsg("提交数据异常");
        }

        return responseMsg;
    }

}
