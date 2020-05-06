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
public enum  SystemAuthorityMappingEnum {
    ID(18949385329987L, "sys_system_authority_mapping", "id", "主键id"),
    SYSTEM_ID(18949385329988L, "sys_system_authority_mapping", "system_Id", ""),
    AUTHORITY_ID(18949385329989L, "sys_system_authority_mapping", "authority_id", "权限id"),
;

    private Long id;
    private String table;
    private String column;
    private String desc;
}
