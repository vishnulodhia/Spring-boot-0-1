package com.springBootLearning.spring_boot_0_1.Auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAvailImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
//        get security
//         get authentications
//         get user from token
        return Optional.of("Here is vishnu but we can change in spring security");
    }
}
