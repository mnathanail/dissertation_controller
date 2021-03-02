package com.dissertation.controller.controller.controller.login;

import com.dissertation.controller.controller.auth.jwt.services.MyUserDetailsService;
import com.dissertation.controller.controller.auth.jwt.util.JWTUtil;
import com.dissertation.controller.controller.model.login.Login;
import com.dissertation.controller.controller.model.login.ResponseLogin;
import com.dissertation.controller.controller.model.profile.Candidate;
import com.dissertation.controller.controller.service.login.ILogin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final ILogin loginService;

    private final AuthenticationManager authenticationManager;

    private final MyUserDetailsService userDetailsService;

    private final JWTUtil jwtTokenUtil;

    private final PasswordEncoder bCryptEncoder;

    @PatchMapping("/login")
    public ResponseEntity<ResponseLogin> loginAction(@RequestBody Login credentials){
        ResponseLogin response = this.loginService.login(credentials);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Login authenticationRequest) throws Exception{
        try{
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )
            );

            Candidate user = (Candidate) authenticate.getPrincipal();

            Candidate candidate = this.userDetailsService.loadUserByEmail(user.getUsername());

            if (candidate.getProfilePic() != null) {
                candidate.setImage(new String(candidate.getProfilePic(), StandardCharsets.UTF_8));
            }

            final String jwt  = jwtTokenUtil.generateToken(user);

            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.AUTHORIZATION,
                            jwtTokenUtil.generateToken(user)
                    )
                    .body(candidate);

            //return ResponseEntity.ok(new ResponseJwt(jwt));

        }catch (BadCredentialsException bce){
            throw new Exception(bce + " OIncorrect username or password");
        }

        /*final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt  = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new ResponseJwt(jwt));*/
    }

}
