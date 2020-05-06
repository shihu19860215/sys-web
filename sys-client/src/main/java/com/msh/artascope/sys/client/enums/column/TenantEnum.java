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
public enum  TenantEnum {
    ID(18949385417550L, "sys_tenant", "id", "主键id"),
    PRIMARY_USER_ID(18949385417551L, "sys_tenant", "primary_user_id", "主账号id"),
    STATUS(18949385417552L, "sys_tenant", "status", "状态"),
    TENANT_START_TIME(18949385417553L, "sys_tenant", "tenant_start_time", "租户开始时间"),
    TENANT_END_TIME(18949385417554L, "sys_tenant", "tenant_end_time", "租户结束时间"),
    OPERATOR_ID(18949385417555L, "sys_tenant", "operator_id", "操作人"),
    CREATE_TIME(18949385417556L, "sys_tenant", "create_time", "创建时间"),
    UPDATE_TIME(18949385417557L, "sys_tenant", "update_time", "更新时间"),
;

    private Long id;
    private String table;
    private String column;
    private String desc;
}
