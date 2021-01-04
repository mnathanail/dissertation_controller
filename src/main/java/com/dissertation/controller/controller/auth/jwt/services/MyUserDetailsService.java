package com.dissertation.controller.controller.auth.jwt.services;

import com.dissertation.controller.controller.model.profile.Candidate;
import com.dissertation.controller.controller.service.profile.IProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final IProfile iProfile;

    private Candidate globalCandidate = null;

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        //email instead of username!
        Candidate candidate = this.iProfile.findByEmail(email).orElseThrow();
        Set<SimpleGrantedAuthority> authorities = candidate.getAuthorities().stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_"+role.getAuthority()))
            .collect(Collectors.toSet());
        globalCandidate = candidate;
        BeanUtils.copyProperties(candidate, globalCandidate);

        return new User(candidate.getEmail(), candidate.getPassword(), authorities);
    }

    public Candidate loadUserByEmail(String email) throws UsernameNotFoundException {
        if(globalCandidate!=null){
            return globalCandidate;
        }
        else {
            Optional<Candidate> candidate = this.iProfile.findByEmail(email);
            return candidate.orElseThrow();
        }
    }

}
