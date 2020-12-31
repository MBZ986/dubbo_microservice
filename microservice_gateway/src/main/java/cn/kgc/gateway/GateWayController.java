package cn.kgc.gateway;

import cn.kgc.service.DeptService;
import cn.kgc.service.EmpService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/router")
public class GateWayController {

//    @Reference(check = false)
//    private EmpService empService;
//
//    @Reference(check = false)
//    private DeptService deptService;
//
//    @RequestMapping("/emp/{path}")
//    public String getEmp(@PathVariable("path")String path, HttpServletRequest request){
//        String realPath = null;
//        System.out.println("调用网关路由到Emp服务");
//        String requestURI = request.getRequestURI();
//        System.out.println("路由请求地址："+requestURI);
//
//        empService.info();
//        realPath = getPath(path);
//
//        return realPath;
//    }
//
//    @RequestMapping("/dept/{path}")
//    public String getDept(@PathVariable("path")String path,HttpServletRequest request){
//        String realPath = null;
//        System.out.println("调用网关路由到Dept服务");
//        String requestURI = request.getRequestURI();
//        System.out.println("路由请求地址："+requestURI);
//
//        deptService.info();
//        realPath = getPath("dept/"+path);
//
//        return realPath;
//    }
//
//    private String getPath(String path){
//        String remoteHost = RpcContext.getContext().getRemoteHost();
//        System.out.println(remoteHost);
//
//        String realPath = String.format("http://%s:%s/%s",remoteHost,8888,path);
//        return realPath;
//    }
}



