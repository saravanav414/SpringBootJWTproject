package com.authjwt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authjwt.entity.UserInfo;
import com.authjwt.repository.UserInfoRepository;
import com.authjwt.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserInfo userInfo) {
        userInfo.setPwd(passwordEncoder.encode(userInfo.getPwd()));
        userInfoRepository.save(userInfo);
        return "User added successfully";
    }
}
