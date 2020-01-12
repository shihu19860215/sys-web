package com.msh.artascope.sys.web.config;

import com.msh.frame.common.aop.aspect.AbstractInfoLoggerAspect;
import com.msh.frame.web.util.HttpServletRequestUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(11)
@Component
public class ControllerInfoLogAop extends AbstractInfoLoggerAspect {
    @Override
    @Pointcut("this(com.msh.frame.web.base.BaseController)")
    protected void pointcut() {
    }

    @Override
    protected Long getTraceId() {
        return HttpServletRequestUtil.getTraceId();
    }
}

