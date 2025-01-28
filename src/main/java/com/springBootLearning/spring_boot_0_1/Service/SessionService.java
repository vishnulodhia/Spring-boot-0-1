package com.springBootLearning.spring_boot_0_1.Service;

import com.springBootLearning.spring_boot_0_1.Model.Session;
import com.springBootLearning.spring_boot_0_1.Model.User;
import com.springBootLearning.spring_boot_0_1.Repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;
    private final int SESSION_LIMIT = 2;
    public void generateNewSession(User user,String refreshToken){
        List<Session> userSession = sessionRepository.findByUser(user);

        if(userSession.size()>= user.getSubscription().getSessionLimit()){
            userSession.sort(Comparator.comparing(Session::getLastUsedAt));
            Session leastRecentlyUseSession = userSession.get(0);
            sessionRepository.delete(leastRecentlyUseSession);
        }
        Session session = Session.builder().user(user).refreshToken(refreshToken).build();
        sessionRepository.save(session);
    }

    public void validateSession(String refreshToken){
        Session session = sessionRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()-> new SessionAuthenticationException("Session not found for refresh token: "+refreshToken));
        session.setLastUsedAt(LocalDateTime.now());
        sessionRepository.save(session);
    }

    public void logout(User user){
        sessionRepository.deleteByUser(user);
    }

}
