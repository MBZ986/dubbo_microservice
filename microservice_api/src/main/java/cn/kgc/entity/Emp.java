package cn.kgc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private String sex;
    private Integer age;
    private String phone;
    private String address;
    private String email;
    private Department department;
}
