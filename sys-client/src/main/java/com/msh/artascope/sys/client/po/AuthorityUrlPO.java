package com.msh.artascope.sys.client.po;


import java.util.Date;
import com.msh.frame.client.base.BasePO;
import com.msh.frame.client.validation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-09 17:21:47
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
	@ApiModelProperty("连接权限 1拥有权限可访问 2用户登录可访问 3无需登录可访问")
	private Integer linkAuth;


}



