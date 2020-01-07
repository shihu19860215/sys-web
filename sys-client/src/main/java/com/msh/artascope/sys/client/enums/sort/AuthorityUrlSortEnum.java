package com.msh.artascope.sys.client.enums.sort;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 18:01:23
 */
public enum  AuthorityUrlSortEnum {
    ID("id","主键id"),
    AUTHORITY_ID("authority_id","权限id"),
    LINK_AUTH("link_auth","连接权限 1拥有权限可访问 2用户登录可访问 3无需登录可访问"),
    STATUS("status","状态"),
    CREATE_TIME("create_time","创建时间"),
    UPDATE_TIME("update_time","更新时间"),
;

    private String desc;
    private String sortColumn;

    private AuthorityUrlSortEnum(String sortColumn,String desc) {
        this.sortColumn = sortColumn;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getSortColumn() {
        return sortColumn;
    }
}
