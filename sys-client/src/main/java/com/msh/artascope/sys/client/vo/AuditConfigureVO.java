package com.msh.artascope.sys.client.vo;

import com.msh.artascope.sys.client.po.AuditConfigurePO;
import java.util.Date;
import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("审计配置")
public class AuditConfigureVO extends AuditConfigurePO {

	public AuditConfigureVO(){}
	public AuditConfigureVO(AuditConfigurePO auditConfigurePO){
		this.setId(auditConfigurePO.getId());
		this.setClassName(auditConfigurePO.getClassName());
		this.setFieldName(auditConfigurePO.getFieldName());
		this.setMeaning(auditConfigurePO.getMeaning());
		this.setStatus(auditConfigurePO.getStatus());
		this.setTenantId(auditConfigurePO.getTenantId());
		this.setOperatorId(auditConfigurePO.getOperatorId());
		this.setUpdateVersion(auditConfigurePO.getUpdateVersion());
		this.setCreateTime(auditConfigurePO.getCreateTime());
		this.setUpdateTime(auditConfigurePO.getUpdateTime());
	}
}


