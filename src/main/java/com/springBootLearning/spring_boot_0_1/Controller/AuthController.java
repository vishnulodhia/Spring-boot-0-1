package com.springBootLearning.spring_boot_0_1.Controller;

import com.springBootLearning.spring_boot_0_1.Dto.LoginRequest;
import com.springBootLearning.spring_boot_0_1.Dto.SignUpDto;
import com.springBootLearning.spring_boot_0_1.Dto.UserDto;
import com.springBootLearning.spring_boot_0_1.Service.AuthService;
import com.springBootLearning.spring_boot_0_1.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto){
        UserDto userDto = userService.signUp(signUpDto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        String token = authService.login(loginRequest);
        return ResponseEntity.ok(token);
    }


}
