package com.jxy.study.service.imp;

import com.jxy.study.service.Jax_wsTestService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * @author jxy
 * @className Jax_wsTestServiceImp
 * @description 描述
 * @date 2020/3/16 20:52
 */
@Service
@WebService(serviceName="Jax_wsTestService",targetNamespace="http://Jax_wsTestService/service",name="Jax_wsTestService",portName="Jax_wsTestServicePort")
public class Jax_wsTestServiceImp implements Jax_wsTestService {
    @Override
    public String say(String userName) {
        return "hello," + userName + ",i am a Jax_wsTestService";
    }

}
