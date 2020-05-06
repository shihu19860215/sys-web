package com.msh.artascope.sys.client.back.vo;

import com.msh.artascope.sys.client.back.po.AuthorityPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-09 17:21:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("权限列表")
public class AuthorityVO extends AuthorityPO {
	@ApiModelProperty("类型描述")
	private String typeDesc;
	@ApiModelProperty("父节点名")
	private String parentName;
	@ApiModelProperty("子权限列表")
	private List<AuthorityVO> children;

	public AuthorityVO(){}
	public AuthorityVO(AuthorityPO authorityPO){
		this.setId(authorityPO.getId());
		this.setName(authorityPO.getName());
		this.setCode(authorityPO.getCode());
		this.setParentId(authorityPO.getParentId());
		this.setLayer(authorityPO.getLayer());
		this.setType(authorityPO.getType());
		this.setSort(authorityPO.getSort());
		this.setIcon(authorityPO.getIcon());
		this.setStatus(authorityPO.getStatus());
		this.setUpdateVersion(authorityPO.getUpdateVersion());
		this.setCreateTime(authorityPO.getCreateTime());
		this.setUpdateTime(authorityPO.getUpdateTime());
	}
}


