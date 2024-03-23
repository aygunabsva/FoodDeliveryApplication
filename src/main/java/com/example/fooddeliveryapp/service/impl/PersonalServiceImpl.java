package com.example.fooddeliveryapp.service.impl;

import com.example.fooddeliveryapp.dto.request.PersonalRegisterDTO;
import com.example.fooddeliveryapp.dto.response.CustomerDTO;
import com.example.fooddeliveryapp.dto.response.PersonalDTO;
import com.example.fooddeliveryapp.entity.Authority;
import com.example.fooddeliveryapp.entity.Customer;
import com.example.fooddeliveryapp.entity.Personal;
import com.example.fooddeliveryapp.entity.Users;
import com.example.fooddeliveryapp.enums.Roles;
import com.example.fooddeliveryapp.exception.AlreadyExistException;
import com.example.fooddeliveryapp.mapper.PersonalMapper;
import com.example.fooddeliveryapp.mapper.UserMapper;
import com.example.fooddeliveryapp.repository.PersonalRepository;
import com.example.fooddeliveryapp.repository.UsersRepository;
import com.example.fooddeliveryapp.service.PersonalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@Slf4j
@RequiredArgsConstructor
public class PersonalServiceImpl implements PersonalService {
    private final PersonalRepository personalRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;
    private final PersonalMapper personalMapper;
    private final UserMapper userMapper;

    public PersonalDTO register(PersonalRegisterDTO personalRegisterDTO) {
        log.info("Personal register method started");
        if (usersRepository.findByUsername(personalRegisterDTO.getUsername()).isPresent()) {
            throw new AlreadyExistException("This user already exist");
        } else {
            Set<Authority> authorities = new HashSet<>();
            authorities.add(new Authority(Roles.PERSONAL.name()));
            personalRegisterDTO.setPassword(passwordEncoder.encode(personalRegisterDTO.getPassword()));
            Users user = userMapper.personalRegisterDTOToUser(personalRegisterDTO);
            user.setAuthorities(authorities);
            Users savedUser = usersRepository.save(user);
            Personal personal = personalMapper.toEntity(personalRegisterDTO);
            personal.setUser(savedUser);
            Personal savedPersonal = personalRepository.save(personal);
            PersonalDTO personalDTO = personalMapper.toDto(savedPersonal);
            log.info("User registered as a personal role, username: {}", user.getUsername());
            return personalDTO;
        }
    }

    @Override
    public List<PersonalDTO> getAll() {
        log.info("Personal getAll method started");
        List<Personal> personals = personalRepository.findAll();
        List<PersonalDTO> personalDTOS = new ArrayList<>();

        for (Personal personal : personals) {
            PersonalDTO personalDTO = personalMapper.toDto(personal);
            personalDTOS.add(personalDTO);
        }
        log.info("Found {} personals", personalDTOS.size());
        return personalDTOS;
    }
}
