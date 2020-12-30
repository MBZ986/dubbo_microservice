package cn.kgc.dto;

import cn.kgc.constant.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMsg {
    private Integer code;
    private ResponseStatus responseStatus;
    private String msg;
    private Object data;
}
