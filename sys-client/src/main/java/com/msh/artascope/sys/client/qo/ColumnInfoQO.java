package com.msh.artascope.sys.client.qo;

import java.util.Date;
import com.msh.frame.client.base.BaseQO;
import com.msh.frame.client.validation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-09 17:21:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("字段详情QO")
public class ColumnInfoQO extends BaseQO {
	@ApiModelProperty("表名")
	private String tableName;

	@ApiModelProperty("字段名")
	private String columnName;

	@ApiModelProperty("标题")
	private String title;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

}