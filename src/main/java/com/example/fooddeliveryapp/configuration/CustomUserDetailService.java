package com.example.fooddeliveryapp.configuration;

import com.example.fooddeliveryapp.entity.Authority;
import com.example.fooddeliveryapp.entity.Users;
import com.example.fooddeliveryapp.enums.UserStatus;
import com.example.fooddeliveryapp.exception.IsNotActiveException;
import com.example.fooddeliveryapp.exception.NotFoundException;
import com.example.fooddeliveryapp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailService implements UserDetailsService {
    private final UsersRepository userRepository;


    private void checkUserProfileStatus(Users user) {
        if (user.getUserStatus() != UserStatus.ACTIVE) {
            throw new IsNotActiveException(user.getUsername() + " is not active");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("user not found"));
        checkUserProfileStatus(user);
        Set<Authority> authoritySet = user.getAuthorities();

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(String.valueOf(authoritySet))
                .build();
    }
}
