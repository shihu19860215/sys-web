package com.msh.artascope.sys.client.enums.sort;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-09 17:21:47
 */
public enum  UserRoleMappingSortEnum {
    ID("id","主键id"),
    USER_ID("user_id","用户id"),
    ROLE_ID("role_id","角色id"),
    SYSTEM_ID("system_id","系统id"),
    STATUS("status","状态"),
    TENANT_ID("tenant_id","租户id"),
    OPERATOR_ID("operator_id","操作人"),
    CREATE_TIME("create_time","创建时间"),
    UPDATE_TIME("update_time","更新时间"),
;

    private String desc;
    private String sortColumn;

    private UserRoleMappingSortEnum(String sortColumn,String desc) {
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
