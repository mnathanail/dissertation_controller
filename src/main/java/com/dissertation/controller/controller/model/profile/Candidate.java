package com.dissertation.controller.controller.model.profile;

import com.dissertation.controller.controller.model.Role;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class Candidate implements UserDetails, Serializable {

    private Long id;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Surname is required")
    private String surname;
    @NotEmpty(message = "Password is required")
    private String password;
    @NotEmpty(message = "Name is required")
    @Email
    private String email;
    private String image;
    private byte[] profilePic;

    private boolean enabled = true;
    private Set<Role> authorities = new HashSet<>();

    public Candidate() {
    }

    public Candidate(String email, String password, Set<Role> authorities, Long id) {
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.id = id;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }
}
