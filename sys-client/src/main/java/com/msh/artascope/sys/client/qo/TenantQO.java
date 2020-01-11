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
@ApiModel("租户信息QO")
public class TenantQO extends BaseQO {
	@ApiModelProperty("租户名")
	private String name;

	@ApiModelProperty("主账号id")
	private Long primaryUserId;

	@ApiModelProperty("租户开始时间")
	private Date tenantStartTime;

	@ApiModelProperty("租户结束时间")
	private Date tenantEndTime;

	@ApiModelProperty("操作人")
	private Long operatorId;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

}