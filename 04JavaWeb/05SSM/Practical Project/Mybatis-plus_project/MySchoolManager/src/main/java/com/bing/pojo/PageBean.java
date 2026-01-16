package com.bing.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页数据实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "分页实体类")
public class PageBean<T> {
    @ApiModelProperty("总数量")
    private Long total;    //总数量
    @ApiModelProperty("当前页数据")
    private List<T> rows;  //当前页数据
}
