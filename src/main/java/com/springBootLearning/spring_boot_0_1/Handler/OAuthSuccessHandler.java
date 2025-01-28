package com.springBootLearning.spring_boot_0_1.Handler;

import com.springBootLearning.spring_boot_0_1.Model.User;
import com.springBootLearning.spring_boot_0_1.Security.JwtService;
import com.springBootLearning.spring_boot_0_1.Service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class OAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final  UserService userService;
    private final JwtService jwtService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

    OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
    DefaultOAuth2User oAuth2User = (DefaultOAuth2User)  token.getPrincipal();
    String email = oAuth2User.getAttribute("email");
    User currentUser = userService.getUserByEmail(email);

    if(currentUser == null){
        User newUser = User.builder().email(oAuth2User.getAttribute("email")).name(oAuth2User.getAttribute("name")).build();
        currentUser = userService.createUser(newUser);
    }

    String accessToken = jwtService.generateAccessToken(currentUser);
    String refreshToken = jwtService.generateRefersToken(currentUser);
    Cookie cookie = new Cookie("refreshToken",refreshToken);

    String fromEndUrl = "http://localhost:8080/home.html?token="+accessToken;
    getRedirectStrategy().sendRedirect(request,response,fromEndUrl);
}



}
