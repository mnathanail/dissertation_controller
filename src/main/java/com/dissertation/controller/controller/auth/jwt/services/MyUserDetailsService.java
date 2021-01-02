package com.dissertation.controller.controller.auth.jwt.services;

import com.dissertation.controller.controller.model.profile.Candidate;
import com.dissertation.controller.controller.service.profile.IProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final IProfile iProfile;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //email instead of username!
        Candidate candidate = this.iProfile.findByEmail(email);
        return new User(candidate.getEmail(), candidate.getPassword(), new ArrayList<>());
    }
}
