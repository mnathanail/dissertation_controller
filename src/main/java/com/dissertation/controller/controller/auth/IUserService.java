package com.dissertation.controller.controller.auth;

import com.dissertation.controller.controller.model.profile.Candidate;

import java.util.Optional;

public interface IUserService {

    Long saveUser(Candidate user);

    Optional<Candidate> findByEmail(String email);
}
