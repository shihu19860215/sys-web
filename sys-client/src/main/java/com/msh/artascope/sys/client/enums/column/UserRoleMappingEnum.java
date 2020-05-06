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
public enum  UserRoleMappingEnum {
    ID(18949385689203L, "sys_user_role_mapping", "id", "主键id"),
    USER_ID(18949385689204L, "sys_user_role_mapping", "user_id", "用户id"),
    ROLE_ID(18949385689205L, "sys_user_role_mapping", "role_id", "角色id"),
    SYSTEM_ID(18949385689206L, "sys_user_role_mapping", "system_id", "系统id"),
    TENANT_ID(18949385689207L, "sys_user_role_mapping", "tenant_id", "租户id"),
    OPERATOR_ID(18949385689208L, "sys_user_role_mapping", "operator_id", "操作人"),
    CREATE_TIME(18949385689209L, "sys_user_role_mapping", "create_time", "创建时间"),
;

    private Long id;
    private String table;
    private String column;
    private String desc;
}
