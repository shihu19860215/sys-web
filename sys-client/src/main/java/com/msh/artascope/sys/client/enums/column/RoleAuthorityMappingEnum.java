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
public enum  RoleAuthorityMappingEnum {
    ID(18949385137716L, "sys_role_authority_mapping", "id", "主键id"),
    ROLE_ID(18949385137717L, "sys_role_authority_mapping", "role_id", "角色id"),
    AUTHORITY_ID(18949385137718L, "sys_role_authority_mapping", "authority_id", "权限id"),
    TENANT_ID(18949385137719L, "sys_role_authority_mapping", "tenant_id", "租户id"),
    OPERATOR_ID(18949385137720L, "sys_role_authority_mapping", "operator_id", "操作人"),
    CREATE_TIME(18949385137721L, "sys_role_authority_mapping", "create_time", "创建时间"),
;

    private Long id;
    private String table;
    private String column;
    private String desc;
}
