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
public enum  AuthorityUrlEnum {
    ID(18949384708624L, "sys_authority_url", "id", "主键id"),
    AUTHORITY_ID(18949384708625L, "sys_authority_url", "authority_id", "权限id"),
    LINK_AUTH(18949384708626L, "sys_authority_url", "link_auth", "链接权限"),
    STATUS(18949384708627L, "sys_authority_url", "status", "状态"),
;

    private Long id;
    private String table;
    private String column;
    private String desc;
}
