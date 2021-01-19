package com.dissertation.controller.controller.controller.register;


import com.dissertation.controller.controller.auth.jwt.util.JWTUtil;
import com.dissertation.controller.controller.model.profile.Candidate;
import com.dissertation.controller.controller.service.register.IRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RegisterController {

    private final IRegister registerService;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtTokenUtil;
    @Autowired
    private final PasswordEncoder bCryptEncoder;

    @PostMapping("/register")
    public ResponseEntity<Candidate> registerAction(@RequestBody Candidate candidate) throws Exception {
        String unencrypted = candidate.getPassword();
        candidate.setPassword(bCryptEncoder.encode(candidate.getPassword()));
        Candidate c = this.registerService.save(candidate);

        if(c != null){
            try{
                Authentication authenticate = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                c.getEmail(),
                                unencrypted
                        )
                );

                Candidate user = (Candidate) authenticate.getPrincipal();

                return ResponseEntity.ok()
                        .header(
                                HttpHeaders.AUTHORIZATION,
                                jwtTokenUtil.generateToken(user)
                        )
                        .body(c);

            }catch (Exception  bce){
                throw new Exception(bce + " Did not save");
            }
        }
        return null;
    }

}
