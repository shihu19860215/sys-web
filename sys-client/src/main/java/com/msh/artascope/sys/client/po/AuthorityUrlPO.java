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
@ApiModel("权限url")
public class AuthorityUrlPO extends BasePO{
	@ApiModelProperty("权限id")
	private Long authorityId;

	@ApiModelProperty("请求url")
	private String url;

	@ApiModelProperty("连接权限 1拥有权限可访问 2用户登录可访问 3无需登录可访问")
	private Integer linkAuth;


}



