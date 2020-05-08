package com.app.todo.service;

import com.app.todo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserInfoService userInfoDAO;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        if (userName.equals("richard")) {
            return new User(userName, "password", Arrays.asList(new SimpleGrantedAuthority("ADMIN")));
        }

        UserInfo userInfo = userInfoDAO.getUserInfoByUserName(userName);
        GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
        return new User(userInfo.getUserName(), userInfo.getPassword(), Arrays.asList(authority));
    }
}