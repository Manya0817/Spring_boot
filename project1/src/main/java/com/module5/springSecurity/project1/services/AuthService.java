package com.module5.springSecurity.project1.services;

import com.module5.springSecurity.project1.dto.LoginDto;
import com.module5.springSecurity.project1.entities.SessionEntity;
import com.module5.springSecurity.project1.entities.User;
import com.module5.springSecurity.project1.repositories.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final SessionRepository sessionRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String login(LoginDto loginDto) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())
        );

        User user= (User) authentication.getPrincipal();
        String token=jwtService.generateToken(user);
        //removes old session
        sessionRepository.deleteByUser(user);
        //saves new session
        SessionEntity session = new SessionEntity();
        session.setUser(user);
        session.setToken(token);
        sessionRepository.save(session);
        return token;
    }
}
