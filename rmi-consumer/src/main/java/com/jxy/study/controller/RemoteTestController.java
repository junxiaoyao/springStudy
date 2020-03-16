package com.jxy.study.controller;


import com.jxy.study.service.HessianTestService;
import com.jxy.study.service.HttpInvokerTestService;
import com.jxy.study.service.Jax_wsTestService;
import com.jxy.study.service.RmiTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jxy
 * @className RemoteTestController
 * @description 描述
 * @date 2020/3/16 17:19
 */
@RestController
@RequestMapping("rt")
public class RemoteTestController {
    @Autowired
    RmiTestService rmiTestService;
    @Autowired
    HessianTestService hessianTestService;
    @Autowired
    HttpInvokerTestService httpInvokerTestService;
    @Autowired
    Jax_wsTestService jax_wsTestService;
    @GetMapping("rmi")
    public String rmi(@RequestParam("userName") String userName) {
        return rmiTestService.say(userName);
    }
    @GetMapping("hessian")
    public String hessian(@RequestParam("userName") String userName) {
        return hessianTestService.say(userName);
    }


    @GetMapping("httpInvoker")
    public String httpInvoker(@RequestParam("userName") String userName) {
        return httpInvokerTestService.say(userName);
    }
    @GetMapping("jax")
    public String jax_wsTestService(@RequestParam("userName") String userName) {
        return jax_wsTestService.say(userName);
    }
}
