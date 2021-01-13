package com.dissertation.controller.controller.auth.jwt.services;

import com.dissertation.controller.controller.model.profile.Candidate;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SecurityService {

    private final MyUserDetailsService userDetailsService;
    /**
     * Get currently connected User.
     *
     * @return Current User ID.
     */
    public String getCurrentUserId ()
    {
        SecurityContext context = SecurityContextHolder.getContext();

        if (context == null)
        {
            return null;
        }

        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();
        if (auth == null)
        {
            return null;
        }
        Object principal = auth.getPrincipal ();
        if (principal instanceof User)
        {
            Candidate c = this.userDetailsService.loadUserByEmail(((User) principal).getUsername());
            return String.valueOf(c.getId());
        }
        return null;
    }
}
