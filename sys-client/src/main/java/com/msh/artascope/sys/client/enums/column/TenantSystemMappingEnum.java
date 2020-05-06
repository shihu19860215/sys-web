package com.msh.artascope.sys.client.enums.column;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-05-06 17:23:52
 */
@AllArgsConstructor
@Getter
public enum  TenantSystemMappingEnum {
    ID(18949385524059L, "sys_tenant_system_mapping", "id", "主键id"),
    TENANT_ID(18949385524060L, "sys_tenant_system_mapping", "tenant_id", "租户id"),
    SYSTEM_ID(18949385524061L, "sys_tenant_system_mapping", "system_id", "系统id"),
    OPERATOR_ID(18949385524062L, "sys_tenant_system_mapping", "operator_id", "操作人"),
    CREATE_TIME(18949385524063L, "sys_tenant_system_mapping", "create_time", "创建时间"),
;

    private Long id;
    private String table;
    private String column;
    private String desc;
}
