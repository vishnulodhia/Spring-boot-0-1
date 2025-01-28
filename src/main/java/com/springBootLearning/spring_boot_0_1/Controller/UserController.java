package com.springBootLearning.spring_boot_0_1.Controller;

import com.springBootLearning.spring_boot_0_1.Dto.SignUpDto;
import com.springBootLearning.spring_boot_0_1.Dto.UserDto;
import com.springBootLearning.spring_boot_0_1.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto){
        System.out.println("signUpDto: "+signUpDto);
        UserDto userDto = userService.signUp(signUpDto);
        System.out.println("UserDto: "+userDto);
        return ResponseEntity.ok(userDto);
    }
}
