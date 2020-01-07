package com.msh.artascope.sys.client.po;


import java.util.Date;
import com.msh.frame.client.base.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("租户信息")
public class TenantPO extends BasePO{
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


}



