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
public enum  UserSystemMappingEnum {
    ID(18949385771136L, "sys_user_system_mapping", "id", "主键id"),
    USER_ID(18949385771137L, "sys_user_system_mapping", "user_id", "用户id"),
    SYSTEM_ID(18949385771138L, "sys_user_system_mapping", "system_id", "系统id"),
    TENANT_ID(18949385771139L, "sys_user_system_mapping", "tenant_id", "租户id"),
    OPERATOR_ID(18949385771140L, "sys_user_system_mapping", "operator_id", "操作人"),
    CREATE_TIME(18949385771141L, "sys_user_system_mapping", "create_time", "创建时间"),
;

    private Long id;
    private String table;
    private String column;
    private String desc;
}
