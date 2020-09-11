package com.javaweb.service.impl;

import com.javaweb.entity.RoleEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity=userRepository.findByUserName(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<RoleEntity> roleEntityList=userEntity.getRoles();
        List<String> roles=new ArrayList<>();
        for(RoleEntity roleEntity:roleEntityList){
            roles.add(roleEntity.getCode());
        }
        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        if(roles!=null){
            for (String role:roles){
                GrantedAuthority authority= new SimpleGrantedAuthority("ROLE_" +role);
                grantList.add(authority);
            }

        }
        UserDetails userDetails = (UserDetails) new User(userEntity.getUserName(),
                userEntity.getPassword(),grantList);

        return userDetails;
    }
}
