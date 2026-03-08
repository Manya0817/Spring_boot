package com.module5.springSecurity.project1.services;

import com.module5.springSecurity.project1.dto.LoginDto;
import com.module5.springSecurity.project1.dto.SignUpDto;
import com.module5.springSecurity.project1.dto.UserDto;
import com.module5.springSecurity.project1.entities.User;
import com.module5.springSecurity.project1.exceptions.ResourceNotFoundException;
import com.module5.springSecurity.project1.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(()-> new BadCredentialsException("User with email "+username +" not found"));
    }

    public User getUserById(Long userId){
        return userRepository
                .findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User with userId "+ userId+" not found"));
    }


    public UserDto signUp(SignUpDto signUpDto) {
        Optional<User> user=userRepository.findByEmail(signUpDto.getEmail());
        if(user.isPresent()){
            throw new BadCredentialsException("User with email already exists"+ signUpDto.getEmail());
        }
        User toBeCreatedUser=modelMapper.map(signUpDto,User.class);
        toBeCreatedUser.setPassword(passwordEncoder.encode(toBeCreatedUser.getPassword()));
        User savedUser=userRepository.save(toBeCreatedUser);
        return modelMapper.map(savedUser, UserDto.class);
    }


}
