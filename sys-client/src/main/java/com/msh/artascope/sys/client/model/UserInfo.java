package com.msh.artascope.sys.client.model;

import com.msh.artascope.sys.client.po.AuthorityPO;
import com.msh.artascope.sys.client.po.UserPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserInfo {
    @ApiModelProperty("用户id")
    private Long userId;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("手机号码")
    private String tel;
    @ApiModelProperty("租户id")
    private Long tenantId;
    @ApiModelProperty("账号类型")
    private Integer type;
    @ApiModelProperty("使用系统id")
    private Long SystemId;
    @ApiModelProperty("权限id")
    private Set<Long> authIds;
    @ApiModelProperty("url权限")
    private Set<String> authUrls;
    @ApiModelProperty("菜单列表")
    private List<Authority> menuList;

    public UserInfo(UserPO userPO) {
        this.userId = userPO.getId();
        this.tel = userPO.getTel();
        this.nickName = userPO.getNickname();
        this.tenantId = userPO.getTenantId();
    }

    public UserInfo() {
    }

    @Data
    @ApiModel("权限列表")
    public static class Authority{
        @ApiModelProperty("主键ID")
        protected Long id;
        @ApiModelProperty("权限名")
        private String name;
        @ApiModelProperty("编号")
        private String code;
        @ApiModelProperty("图标")
        private String icon;
        @ApiModelProperty("当前使用系统id")
        private Long systemId;
        @ApiModelProperty("子权限列表")
        private List<Authority> children;

        public Authority(AuthorityPO authorityPO) {
            this.id = authorityPO.getId();
            this.name = authorityPO.getName();
            this.code = authorityPO.getCode();
            this.icon = authorityPO.getIcon();
        }

        public Authority() {
        }
    }
}
