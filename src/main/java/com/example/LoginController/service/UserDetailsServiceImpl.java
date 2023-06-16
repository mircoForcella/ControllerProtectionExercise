package com.example.LoginController.service;


import com.example.LoginController.entity.UserEntity;
import com.example.LoginController.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.getUserEntityByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(userEntity);
    }

}