package com.dissertation.controller.controller.model.profile;

import com.dissertation.controller.controller.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class Candidate {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String image;
    private byte[] profilePic;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private Set<Role> authorities;

}
