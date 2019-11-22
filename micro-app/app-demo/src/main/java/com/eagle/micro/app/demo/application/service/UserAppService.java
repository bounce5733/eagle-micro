package com.eagle.micro.app.demo.application.service;

import com.eagle.micro.app.demo.application.api.assembler.UserDTOAssembler;
import com.eagle.micro.app.demo.application.api.request.AddUserRequestDTO;
import com.eagle.micro.app.demo.application.api.response.UserResponseDTO;
import com.eagle.micro.app.demo.application.external.UserExtClient;
import com.eagle.micro.app.demo.application.external.UserExtClientFallback;
import com.eagle.micro.app.demo.application.external.assembler.UserExtAssembler;
import com.eagle.micro.app.demo.application.external.request.AddUserExtRequest;
import com.eagle.micro.app.demo.application.repository.UserReadModelRepository;
import com.eagle.micro.app.demo.common.exception.ErrorCode;
import com.eagle.micro.app.demo.common.exception.UserException;
import com.eagle.micro.app.demo.domain.entity.User;
import com.eagle.micro.app.demo.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 构造器
     * 需要单元测试的类使用构造器注入
     *
     * @param userExtClient
     * @param userExtAssembler
     * @param userDTOAssembler
     * @param userRepository
     * @param userReadModelRepository
     */
    @Autowired
    public UserAppService(UserExtClient userExtClient, UserExtAssembler userExtAssembler, UserDTOAssembler userDTOAssembler, UserRepository userRepository, UserReadModelRepository userReadModelRepository) {
        this.userExtClient = userExtClient;
        this.userExtAssembler = userExtAssembler;
        this.userDTOAssembler = userDTOAssembler;
        this.userRepository = userRepository;
        this.userReadModelRepository = userReadModelRepository;
    }

    /**
     * 创建用户逻辑实现编排
     *
     * @param dto
     */
    public void createUser(AddUserRequestDTO dto) {
        /**
         * 调用外部服务 得到用户id
         */
        log.info("==== 模拟调用外部服务 ====");


        /**
         *创建外部请求对象
         * 通过assembler将RequestDTO转换为请求Request对象
         */
        AddUserExtRequest request = userExtAssembler.assembler(dto);

        /*通过feignclient调用请求*/
        Long id = userExtClient.createUser(request);

        if (UserExtClientFallback.NULL_USER_ID_WHEN_EXT_CREATE_FALLBACK.equals(id)) {
            throw new UserException(ErrorCode.CREATE_FAIL_EXT_CALL_FAIL);
        }

        /*创建用户实体
         * 通过assembler将RequestDTO转换为domain对象*/
        User user = userDTOAssembler.assembler(dto);
        user.setId(id);
        log.info("==== user: {} ====", user);

        /*调用领域行为*/
        user.doSomething();

        /*数据持久化*/
        userRepository.add(user);
    }


    /**
     * 查询用户列表 走读模型
     *
     * @return UserListResponseDTO
     */
    public List<UserResponseDTO> queryUsers() {
        return userReadModelRepository.queryAllForUserResponseDTO();
    }

}
