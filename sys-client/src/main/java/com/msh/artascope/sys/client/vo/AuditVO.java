package com.msh.artascope.sys.client.vo;

import com.msh.artascope.sys.client.po.AuditPO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-16 16:54:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("审计列表")
public class AuditVO extends AuditPO {

	public AuditVO(){}
	public AuditVO(AuditPO auditPO){
		this.setId(auditPO.getId());
		this.setTableName(auditPO.getTableName());
		this.setPrimaryKeyId(auditPO.getPrimaryKeyId());
		this.setBeforeValue(auditPO.getBeforeValue());
		this.setAfterValue(auditPO.getAfterValue());
		this.setComment(auditPO.getComment());
		this.setStatus(auditPO.getStatus());
		this.setTenantId(auditPO.getTenantId());
		this.setOperatorId(auditPO.getOperatorId());
		this.setCreateTime(auditPO.getCreateTime());
	}
}


