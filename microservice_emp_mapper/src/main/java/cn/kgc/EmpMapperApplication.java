package cn.kgc;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDubbo
@SpringBootApplication
@MapperScan(basePackages = "cn.kgc.mapper")
public class EmpMapperApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmpMapperApplication.class,args);
    }
}
