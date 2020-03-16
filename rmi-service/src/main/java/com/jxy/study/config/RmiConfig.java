package com.jxy.study.config;

import com.jxy.study.service.HessianTestService;
import com.jxy.study.service.HttpInvokerTestService;
import com.jxy.study.service.RmiTestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;


/**
 * @author jxy
 * @className RmiConfig
 * @description 描述
 * @date 2020/3/16 17:00
 */
@Configuration
public class RmiConfig {
    /**
     * rmi方式开放服务
     *
     * @param
     * @return org.springframeasdasdsawork.remoting.rmi.RmiServiceExporter
     * @author jxy
     * @date 2020/3/16
     */
    @Bean
    public RmiServiceExporter rmiServiceExporter(RmiTestService service) {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setService(service);
        exporter.setServiceName("rmiTestService");
        exporter.setServiceInterface(RmiTestService.class);
        //注意，RMI方法需要绑定到某端口的注册表上，默认是1099
        exporter.setRegistryPort(9000);
        return exporter;
    }

    /**
     * Hessian方式
     * 因为基于http所以需要映射链接
     *
     * @param hessianTestService
     * @return org.springframework.remoting.caucho.HessianExporter
     * @author jxy
     * @date 2020/3/16
     */
    @Bean(name = "/hessianServiceExporter")
    public HessianServiceExporter hessianExporter(HessianTestService hessianTestService) {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(hessianTestService);
        exporter.setServiceInterface(HessianTestService.class);
        return exporter;
    }

    /**
     * HttpInvoker
     * 因为基于http所以需要映射链接
     *
     * @param service
     * @return org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter
     * @author jxy
     * @date 2020/3/16
     */
    @Bean(name = "/httpInvokerServiceExporter")
    public HttpInvokerServiceExporter httpInvokerServiceExporter(HttpInvokerTestService service) {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(service);
        exporter.setServiceInterface(HttpInvokerTestService.class);
        return exporter;
    }

    /**
     * Jax-ws 不需要指定导出，会将所有含Jax-ws注解的bean导出
     *
     * @param
     * @return org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter
     * @author jxy
     * @date 2020/3/16
     */
    @Bean
    public SimpleJaxWsServiceExporter jaxWsServiceExporter() {
        SimpleJaxWsServiceExporter exporter=new SimpleJaxWsServiceExporter();
        //默认与当前应用使用相同路径，即http://127.0.0.1:8000/
        exporter.setBaseAddress("http://127.0.0.1:8002/services/");
        return exporter;
    }
}
