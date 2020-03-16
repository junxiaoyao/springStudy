package com.jxy.study.config.remote;

import com.jxy.study.service.HessianTestService;
import com.jxy.study.service.HttpInvokerTestService;
import com.jxy.study.service.Jax_wsTestService;
import com.jxy.study.service.RmiTestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author jxy
 * @className RmiConfig
 * @description 描述
 * @date 2020/3/16 17:00
 */
@Configuration
public class RmiConfig {
    public static final String SERVER_URL = "127.0.0.1";

    @Bean
    public RmiProxyFactoryBean rmiProxyFactoryBean() {
        RmiProxyFactoryBean factoryBean = new RmiProxyFactoryBean();
        factoryBean.setServiceUrl("rmi://" + SERVER_URL + ":9000/rmiTestService");
        factoryBean.setServiceInterface(RmiTestService.class);
        return factoryBean;
    }

    @Bean
    public HessianProxyFactoryBean hessianProxyFactoryBean() {
        HessianProxyFactoryBean factoryBean = new HessianProxyFactoryBean();
        factoryBean.setServiceUrl("http://" + SERVER_URL + ":8000/hessianServiceExporter");
        factoryBean.setServiceInterface(HessianTestService.class);
        // factoryBean.setOverloadEnabled(true);
        return factoryBean;
    }

    @Bean
    public HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean() {
        HttpInvokerProxyFactoryBean factoryBean = new HttpInvokerProxyFactoryBean();
        factoryBean.setServiceUrl("http://" + SERVER_URL + ":8000/httpInvokerServiceExporter");
        factoryBean.setServiceInterface(HttpInvokerTestService.class);
        return factoryBean;
    }
    @Bean
    public JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean()throws Exception{
        JaxWsPortProxyFactoryBean jaxProxy=new JaxWsPortProxyFactoryBean();
        jaxProxy.setWsdlDocumentUrl(new URL("http://localhost:8002/services/Jax_wsTestService?wsdl"));
        jaxProxy.setServiceInterface(Jax_wsTestService.class);
        //命名空间，服务名等可从service上的注解指定
        return jaxProxy;
    }
}
