package com.msh.artascope.sys.client.po;


import com.msh.frame.client.base.BasePO;
import com.msh.frame.client.validation.IInsert;
import com.msh.frame.client.validation.IUpdate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-16 16:54:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("权限urlPO")
public class AuthorityUrlPO extends BasePO{
	@NotNull(groups = IInsert.class,message = "authorityId不能为空")
	@ApiModelProperty("权限id")
	private Long authorityId;

	@NotNull(groups = IInsert.class,message = "url不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 100, message = "url长度范围1到100"),
		@Size(groups = IUpdate.class,min = 1,max = 100, message = "url长度范围1到100")
	})
	@ApiModelProperty("请求url")
	private String url;

	@NotNull(groups = IInsert.class,message = "linkAuth不能为空")
	@ApiModelProperty("链接权限")
	private Integer linkAuth;

	@NotNull(groups = IInsert.class,message = "status不能为空")
	@ApiModelProperty("状态")
	private Integer status;

	@NotNull(groups = IUpdate.class, message = "更新版本不能为空")
	@ApiModelProperty("更新版本")
	private Integer updateVersion;


}



