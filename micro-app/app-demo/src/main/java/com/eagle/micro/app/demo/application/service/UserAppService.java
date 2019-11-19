package com.eagle.micro.app.demo.application.service;

import com.eagle.micro.app.demo.application.api.assembler.UserDTOAssembler;
import com.eagle.micro.app.demo.application.external.assembler.UserExtAssembler;
import com.eagle.micro.app.demo.application.repository.UserReadModelRepository;
import com.eagle.micro.app.demo.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * application service 放在application.service包中
 * <p>
 * application service主要处理编排调用
 *
 * @Author jiangyonghua
 * @Date 2019/11/19 16:23
 * @Version 1.0
 **/
@Service
@Slf4j
public class UserAppService {

    private UserExtClient userExtClient;

    private UserExtAssembler userExtAssembler;

    private UserDTOAssembler userDTOAssembler;

    private UserRepository userRepository;

    private UserReadModelRepository userReadModelRepository;

    @Autowired
    public UserAppService(UserExtClient userExtClient, UserExtAssembler userExtAssembler, UserDTOAssembler userDTOAssembler, UserRepository userRepository, UserReadModelRepository userReadModelRepository) {
        userExtClient = userExtClient;
        userExtAssembler = userExtAssembler;
        userDTOAssembler = userDTOAssembler;
        userRepository = userRepository;
        userReadModelRepository = userReadModelRepository;

    }
}
