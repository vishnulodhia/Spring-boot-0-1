package com.springBootLearning.spring_boot_0_1.Controller;

import com.springBootLearning.spring_boot_0_1.Dto.LoginRequest;
import com.springBootLearning.spring_boot_0_1.Dto.LoginResponseDto;
import com.springBootLearning.spring_boot_0_1.Dto.SignUpDto;
import com.springBootLearning.spring_boot_0_1.Dto.UserDto;
import com.springBootLearning.spring_boot_0_1.Service.AuthService;
import com.springBootLearning.spring_boot_0_1.Service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response){
        System.out.println("user:");
        LoginResponseDto loginResponseDto = authService.login(loginRequest);
        Cookie cookie = new Cookie("refreshToken",loginResponseDto.getRefreshToken());
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return ResponseEntity.ok(loginResponseDto);
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponseDto> refreshToken(HttpServletRequest request){

        String refreshToken = Arrays.stream(request.getCookies()).filter(cookie -> "refreshToken".equals(cookie.getName())).
                findFirst().
                map(Cookie::getValue).
                orElseThrow(()->new AuthenticationServiceException("Refresh token not found"));

    return ResponseEntity.ok(authService.refreshToken(refreshToken));
    }


}
