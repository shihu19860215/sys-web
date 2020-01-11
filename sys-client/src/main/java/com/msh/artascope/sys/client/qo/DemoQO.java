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
@ApiModel("demoQO")
public class DemoQO extends BaseQO {
    @NotNull(message = "tenantId不能为空")
	@ApiModelProperty("租户id")
	private Long tenantId;

	@ApiModelProperty("操作人")
	private Long operatorId;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

}