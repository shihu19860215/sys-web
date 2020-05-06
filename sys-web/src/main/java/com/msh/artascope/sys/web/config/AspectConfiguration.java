package com.msh.artascope.sys.web.config;

import com.msh.frame.web.aspect.ControllerInfoLogAspect;
import com.msh.frame.web.aspect.ServiceCommonResultAspect;
import com.msh.frame.web.aspect.ServiceInfoLogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConfiguration {

    @Bean
    public ControllerInfoLogAspect controllerInfoLogAop(){
        return new ControllerInfoLogAspect();
    }

    @Bean
    public ServiceInfoLogAspect serviceInfoLogAspect(){
        return new ServiceInfoLogAspect();
    }

    @Bean
    public ServiceCommonResultAspect serviceCommonResultAspect(){
        return new ServiceCommonResultAspect();
    }
}
