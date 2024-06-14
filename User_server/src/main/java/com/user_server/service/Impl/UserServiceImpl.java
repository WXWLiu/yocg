package com.user_server.service.Impl;

import com.user_server.entity.User;
import com.user_server.mapper.UserMapper;
import com.user_server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    /**
     * 查询所有用户
     * @return List所有用户
     */
    @Override
    public List<User> findUser() {
        return userMapper.selectList(null);
    }
}
