package com.jxy.study.service.imp;

import com.jxy.study.service.HttpInvokerTestService;
import org.springframework.stereotype.Service;

/**
 * @author jxy
 * @className HttpInvokerTestServiceImp
 * @description 描述
 * @date 2020/3/16 20:36
 */
@Service
public class HttpInvokerTestServiceImp implements HttpInvokerTestService {
    @Override
    public String say(String userName) {
        return "hello," + userName + ",i am a HttpInvokerTestService";
    }

}
