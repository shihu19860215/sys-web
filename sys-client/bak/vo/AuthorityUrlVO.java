package com.msh.artascope.sys.client.back.vo;

import com.msh.artascope.sys.client.back.po.AuthorityUrlPO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-09 17:21:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("权限url")
public class AuthorityUrlVO extends AuthorityUrlPO {

	public AuthorityUrlVO(){}
	public AuthorityUrlVO(AuthorityUrlPO authorityUrlPO){
		this.setId(authorityUrlPO.getId());
		this.setAuthorityId(authorityUrlPO.getAuthorityId());
		this.setUrl(authorityUrlPO.getUrl());
		this.setLinkAuth(authorityUrlPO.getLinkAuth());
		this.setStatus(authorityUrlPO.getStatus());
		this.setUpdateVersion(authorityUrlPO.getUpdateVersion());
		this.setCreateTime(authorityUrlPO.getCreateTime());
		this.setUpdateTime(authorityUrlPO.getUpdateTime());
	}
}


