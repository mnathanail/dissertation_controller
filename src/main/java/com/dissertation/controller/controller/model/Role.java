package com.dissertation.controller.controller.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {

    public static final String CANDIDATE = "CANDIDATE";
    public static final String RECRUITER = "RECRUITER";
    public static final String CANDIDATE_RECRUITER = "CANDIDATE_RECRUITER";

    private String authority;

}