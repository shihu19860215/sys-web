package com.msh.artascope.sys.client.qo;

import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collection;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-16 16:54:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("权限urlQO")
public class AuthorityUrlQO extends BaseQO {
	@ApiModelProperty("权限id")
	private Long authorityId;

	@ApiModelProperty("请求url")
	private String url;

	@ApiModelProperty("链接权限")
	private Integer linkAuth;

	@ApiModelProperty("状态")
	private Integer status;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

	@ApiModelProperty("in查询")
	private Collection<Long> inAuthIds;

}