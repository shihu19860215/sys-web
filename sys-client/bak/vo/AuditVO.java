package com.msh.artascope.sys.client.back.vo;

import com.msh.artascope.sys.client.back.po.AuditPO;
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
@ApiModel("审计列表")
public class AuditVO extends AuditPO {

	public AuditVO(){}
	public AuditVO(AuditPO auditPO){
		this.setId(auditPO.getId());
		this.setClassName(auditPO.getClassName());
		this.setFieldName(auditPO.getFieldName());
		this.setPrimaryKeyId(auditPO.getPrimaryKeyId());
		this.setBeforeValue(auditPO.getBeforeValue());
		this.setAfterValue(auditPO.getAfterValue());
		this.setComment(auditPO.getComment());
		this.setStatus(auditPO.getStatus());
		this.setTenantId(auditPO.getTenantId());
		this.setOperatorId(auditPO.getOperatorId());
		this.setUpdateVersion(auditPO.getUpdateVersion());
		this.setCreateTime(auditPO.getCreateTime());
		this.setUpdateTime(auditPO.getUpdateTime());
	}
}


