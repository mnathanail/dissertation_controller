package com.dissertation.controller.controller.controller.login;

import com.dissertation.controller.controller.model.login.Login;
import com.dissertation.controller.controller.model.login.ResponseLogin;
import com.dissertation.controller.controller.service.login.ILogin;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin("http://localhost:4300")
public class LoginController {

    @Autowired
    private ILogin loginService;

    @PatchMapping("/login")
    public ResponseEntity<ResponseLogin> loginAction(@RequestBody Login credentials){
        ResponseLogin response = this.loginService.login(credentials);
        return ResponseEntity.ok(response);
    }
}
