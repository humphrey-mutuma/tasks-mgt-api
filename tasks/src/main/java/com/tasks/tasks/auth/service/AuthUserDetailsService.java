package com.tasks.tasks.auth.service;

import com.tasks.tasks.auth.model.UserPrincipal;
import com.tasks.tasks.auth.repo.AuthRepository;
import com.tasks.tasks.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authRepository.findByUsername(username)
                                         .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }
         return new UserPrincipal(user);
    }
}
