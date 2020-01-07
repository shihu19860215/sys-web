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
@ApiModel("租户系统映射")
public class TenantSystemMappingPO extends BasePO{
	@ApiModelProperty("租户id")
	private Long tenantId;

	@ApiModelProperty("系统id")
	private Long systemId;

	@ApiModelProperty("操作人")
	private Long operatorId;


}



