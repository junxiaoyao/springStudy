package com.jxy.study.service.imp;

import com.jxy.study.service.RmiTestService;
import org.springframework.stereotype.Service;

/**
 * @author jxy
 * @className RmiTestServiceImp
 * @description 描述
 * @date 2020/3/16 17:05
 */
@Service
public class RmiTestServiceImp implements RmiTestService {
    @Override
    public String say(String userName) {
        return "hello," + userName + ",i am a RmiTestService";
    }
}
