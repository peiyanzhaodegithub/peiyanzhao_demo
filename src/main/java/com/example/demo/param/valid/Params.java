package com.example.demo.param.valid;

import com.example.demo.param.valid.annotation.IdentityNo;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/15 15:53
 * @Description: TODO
 */
@Data
public class Params {

    @NotNull(message = "参数不能为null",groups = SaveGroup.class)
    private String name;

    private int age;

    @IdentityNo(groups = SaveGroup.class)
    private String idCard;

    public interface SaveGroup {}
    public interface UpdateGroup {}

}
