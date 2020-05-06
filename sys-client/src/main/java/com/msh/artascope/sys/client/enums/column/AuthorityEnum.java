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
public enum  AuthorityEnum {
    ID(18949384553222L, "sys_authority", "id", "主键id"),
    PARENT_ID(18949384553479L, "sys_authority", "parent_id", "父权限"),
    LAYER(18949384553480L, "sys_authority", "layer", "层级"),
    TYPE(18949384553481L, "sys_authority", "type", "权限类型"),
    SORT(18949384553482L, "sys_authority", "sort", "排序值"),
    STATUS(18949384553483L, "sys_authority", "status", "状态"),
;

    private Long id;
    private String table;
    private String column;
    private String desc;
}
