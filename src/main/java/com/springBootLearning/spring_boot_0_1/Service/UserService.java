package com.springBootLearning.spring_boot_0_1.Service;

import com.springBootLearning.spring_boot_0_1.Dto.LoginRequest;
import com.springBootLearning.spring_boot_0_1.Dto.SignUpDto;
import com.springBootLearning.spring_boot_0_1.Dto.UserDto;
import com.springBootLearning.spring_boot_0_1.Exception.ResourceNotFoundException;
import com.springBootLearning.spring_boot_0_1.Model.User;
import com.springBootLearning.spring_boot_0_1.Repository.UserRepository;
import com.springBootLearning.spring_boot_0_1.Security.JwtService;
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
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{


    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByEmail(username)
                .orElseThrow(()-> new BadCredentialsException("User not found"));
    }

    public UserDto signUp(SignUpDto signUpDto){
       try{
           Optional<User> user = userRepository.findByEmail(signUpDto.getEmail());

           if(user.isPresent())
               throw new BadCredentialsException("User with email already exits"+ signUpDto.getEmail());


           User toBeCreated = mapper.map(signUpDto,User.class);
           toBeCreated.setPassword(passwordEncoder.encode(toBeCreated.getPassword()));


           return mapper.map(userRepository.save(toBeCreated),UserDto.class);

       }
       catch (Exception e){
           e.printStackTrace();;
           throw e;
       }
    }


    public User findUserById(Long userid){
       return userRepository.findById(userid).orElseThrow(()-> new ResourceNotFoundException("User not found"));
    }

}
