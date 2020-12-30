package cn.kgc;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableDubbo
@SpringBootApplication
@MapperScan({"cn.kgc.mapper"})
public class DeptMapperApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DeptMapperApplication.class, args);

    }
}
