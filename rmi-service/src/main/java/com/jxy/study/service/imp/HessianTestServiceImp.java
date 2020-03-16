package com.jxy.study.service.imp;

import com.jxy.study.service.HessianTestService;
import org.springframework.stereotype.Service;

/**
 * @author jxy
 * @className HessianTestServiceImp
 * @description 描述
 * @date 2020/3/16 17:49
 */
@Service
public class HessianTestServiceImp implements HessianTestService {
    @Override
    public String say(String userName) {
        return "hello," + userName + ",i am a HessianTestService";
    }

}
