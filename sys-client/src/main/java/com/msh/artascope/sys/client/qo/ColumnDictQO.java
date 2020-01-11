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
@ApiModel("字段字典QO")
public class ColumnDictQO extends BaseQO {
	@ApiModelProperty("字段id")
	private Long columnId;

	@ApiModelProperty("数据库值")
	private Integer value;

	@ApiModelProperty("实际意思")
	private String meaning;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

}