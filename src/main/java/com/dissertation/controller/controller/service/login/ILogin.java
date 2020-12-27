package com.dissertation.controller.controller.service.login;

import com.dissertation.controller.controller.model.login.Login;
import com.dissertation.controller.controller.model.login.ResponseLogin;

public interface ILogin {
    ResponseLogin login(Login credentials);


}
