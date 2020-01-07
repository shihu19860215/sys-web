package com.msh.artascope.sys.web.config;

import com.msh.frame.web.util.HttpServletRequestUtil;
import com.msh.artascope.sys.service.config.AbstractServiceCommonResultAspect;
import org.springframework.stereotype.Component;


/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
@Component
public class ServiceCommonResultAop extends AbstractServiceCommonResultAspect {

    @Override
    protected Long getTraceId() {
        return HttpServletRequestUtil.getTraceId();
    }
}
