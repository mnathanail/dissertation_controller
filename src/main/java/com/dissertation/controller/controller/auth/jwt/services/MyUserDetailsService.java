package com.dissertation.controller.controller.auth.jwt.services;

import com.dissertation.controller.controller.model.Role;
import com.dissertation.controller.controller.model.profile.Candidate;
import com.dissertation.controller.controller.service.profile.IProfile;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


@NoArgsConstructor
@AllArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private IProfile iProfile;

    private Candidate globalCandidate = null;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //email instead of username!
        Candidate candidate = this.iProfile.findByEmail(email);

        Set<Role> authorities = candidate.getAuthorities().stream()
            .map(role -> new Role("ROLE_"+role.getAuthority()))
            .collect(Collectors.toSet());
        globalCandidate = candidate;
        BeanUtils.copyProperties(candidate, globalCandidate);

        return new Candidate(candidate.getEmail(), candidate.getPassword(), authorities,candidate.getId());
    }

    public Candidate loadUserByEmail(String email) throws UsernameNotFoundException {
        if(globalCandidate!=null){
            return globalCandidate;
        }
        else {
            Candidate candidate = this.iProfile.findByEmail(email);
            return candidate;
        }
    }

}
