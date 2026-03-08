package com.module5.springSecurity.project1.services;

import com.module5.springSecurity.project1.dto.LoginDto;
import com.module5.springSecurity.project1.dto.LoginResponseDto;
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
    private final UserService userService;

    public LoginResponseDto login(LoginDto loginDto) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())
        );

        User user= (User) authentication.getPrincipal();
        String accessToken=jwtService.generateAccessToken(user);
        String refreshToken=jwtService.generateRefreshToken(user);
        //removes old session
//        sessionRepository.deleteByUser(user);
//        //saves new session
//        SessionEntity session = new SessionEntity();
//        session.setUser(user);
//        session.setToken(token);
//        sessionRepository.save(session);

        return new LoginResponseDto(user.getId(),accessToken,refreshToken);
    }

    public LoginResponseDto refreshToken(String refreshToken) {
        Long userId=jwtService.getUserIdFromToken(refreshToken);
        User user=userService.getUserById(userId);
        String accessToken=jwtService.generateAccessToken(user);
        return new LoginResponseDto(user.getId(),accessToken,refreshToken);
    }
}
