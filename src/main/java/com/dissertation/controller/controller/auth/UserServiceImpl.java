package com.dissertation.controller.controller.auth;

import com.dissertation.controller.controller.model.profile.Candidate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserServiceImpl implements IUserService, UserDetailsService {

   /* @Autowired
    private BCryptPasswordEncoder bCryptEncoder;*/



    @Override
    public Long saveUser(Candidate candidate) {
        //candidate.setPassword(bCryptEncoder.encode(candidate.getPassword()));

        return null;
    }

    @Override
    public Optional<Candidate> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        /*Optional<Candidate> opt = userRepo.findByEmail(email);

        org.springframework.security.core.userdetails.User springUser=null;

        if(!opt.isPresent()){
            throw new UsernameNotFoundException("User does not found ");
        }
        else{
            Candidate candidate = opt.get();
            Set<String> roles = candidate.getRoles();
            Set<GrantedAuthority> ga = new HashSet<>();
            for(String role:roles) {
                ga.add(new SimpleGrantedAuthority(role));
            }
            springUser = new org.springframework.security.core.userdetails.User(
                    email,
                    candidate.getPassword(),
                    ga);
        }

        return springUser;*/
        return null;
    }
}
