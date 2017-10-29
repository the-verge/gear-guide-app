package com.verge.resource;

import com.verge.dto.Credentials;
import com.verge.dto.UserInfo;
import com.verge.utiliities.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private AuthenticationManager authenticationManager;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody Credentials credentials) {
        Authentication auth = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());

        try {
            authenticationManager.authenticate(auth);
        } catch (BadCredentialsException e) {
            return Responses.unauthorized("Bad credentials");
        }

        UserInfo user = new UserInfo(credentials.getUsername());
        return Responses.ok(user);
    }

}
