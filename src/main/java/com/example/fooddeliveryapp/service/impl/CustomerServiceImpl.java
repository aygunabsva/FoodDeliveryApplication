package com.example.fooddeliveryapp.service.impl;

import com.example.fooddeliveryapp.dto.request.CustomerRegisterDTO;
import com.example.fooddeliveryapp.dto.response.CustomerDTO;
import com.example.fooddeliveryapp.entity.Authority;
import com.example.fooddeliveryapp.entity.Customer;
import com.example.fooddeliveryapp.entity.Users;
import com.example.fooddeliveryapp.enums.Roles;
import com.example.fooddeliveryapp.exception.AlreadyExistException;
import com.example.fooddeliveryapp.mapper.CustomerMapper;
import com.example.fooddeliveryapp.mapper.UserMapper;
import com.example.fooddeliveryapp.repository.CustomerRepository;
import com.example.fooddeliveryapp.repository.UsersRepository;
import com.example.fooddeliveryapp.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;
    private final CustomerMapper customerMapper;
    private final UserMapper userMapper;

    public CustomerDTO register(CustomerRegisterDTO customerRegisterDTO) {
        log.info("customer register method started");
        if (usersRepository.findByUsername(customerRegisterDTO.getUsername()).isPresent()) {
            throw new AlreadyExistException("This user already exist");
        } else {
            Set<Authority> authorities = new HashSet<>();
            authorities.add(new Authority(Roles.CUSTOMER.name()));
            customerRegisterDTO.setPassword(passwordEncoder.encode(customerRegisterDTO.getPassword()));
            Users user = userMapper.customerRegisterDTOToUser(customerRegisterDTO);
            user.setAuthorities(authorities);
            Users savedUser = usersRepository.save(user);
            Customer customer = customerMapper.toEntity(customerRegisterDTO);
            customer.setUser(savedUser);
            Customer savedCustomer = customerRepository.save(customer);
            CustomerDTO customerDTO = customerMapper.toDto(savedCustomer);
            log.info("user registered as a customer role, username: {}", user.getUsername());
            return customerDTO;
        }
    }

    public List<CustomerDTO> getAll() {
        log.info("customer getAll method started");
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO customerDTO = customerMapper.toDto(customer);
            customerDTOS.add(customerDTO);
        }
        log.info("customer getAll method finished");
        return customerDTOS;
    }

}
