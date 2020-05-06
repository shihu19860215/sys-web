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
public enum  RoleEnum {
    ID(18949385026855L, "sys_role", "id", "主键id"),
    SYSTEM_ID(18949385026856L, "sys_role", "system_id", "系统id"),
    STATUS(18949385026857L, "sys_role", "status", "状态"),
    TENANT_ID(18949385026858L, "sys_role", "tenant_id", "租户id"),
    OPERATOR_ID(18949385026859L, "sys_role", "operator_id", "操作人"),
    CREATE_TIME(18949385027116L, "sys_role", "create_time", "创建时间"),
    UPDATE_TIME(18949385027117L, "sys_role", "update_time", "更新时间"),
;

    private Long id;
    private String table;
    private String column;
    private String desc;
}
