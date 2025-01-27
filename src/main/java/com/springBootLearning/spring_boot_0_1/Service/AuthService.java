package com.springBootLearning.spring_boot_0_1.Service;

import com.springBootLearning.spring_boot_0_1.Dto.LoginRequest;
import com.springBootLearning.spring_boot_0_1.Dto.LoginResponseDto;
import com.springBootLearning.spring_boot_0_1.Exception.ResourceNotFoundException;
import com.springBootLearning.spring_boot_0_1.Model.User;
import com.springBootLearning.spring_boot_0_1.Repository.UserRepository;
import com.springBootLearning.spring_boot_0_1.Security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final SessionService sessionService;


    public LoginResponseDto login(LoginRequest loginRequest){
        try{
            System.out.println("loginRequest: "+loginRequest);
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword())
            );
            User user = (User) authentication.getPrincipal();
            System.out.println("user: "+user);

            String accessToken = jwtService.generateAccessToken(user);
            String refreshToken = jwtService.generateRefersToken(user);
            sessionService.generateNewSession(user,refreshToken);


            System.out.println("accessToken: "+accessToken);
            System.out.println("refreshToken: "+refreshToken);
            return new LoginResponseDto(user.getUserId(),accessToken,refreshToken);
        }
        catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public LoginResponseDto refreshToken(String refreshToken){
       Long userId = jwtService.getUserIdFromToken(refreshToken);
       sessionService.validateSession(refreshToken);
       User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found"));
       String accessToken = jwtService.generateRefersToken(user);

        return new LoginResponseDto(user.getUserId(),accessToken,refreshToken);
    }


    public void logout(String refreshToken) {
        User user = userRepository.findById(jwtService.getUserIdFromToken(refreshToken)).orElseThrow(()->new ResourceNotFoundException("User not found"));
        sessionService.logout(user);
    }
}
