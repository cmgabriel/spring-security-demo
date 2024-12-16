package com.coreinventor.springsecurity6demo.user;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/welcome")
    public ResponseEntity<Object> welcomeMessage(){
        Map<String,String> map = new HashMap<>();
        map.put("message","Welcome to spring security demo");
        return new ResponseEntity<>(map,
                HttpStatus.OK);
    }

    @GetMapping("/csrf")
    public ResponseEntity<Object> getCSRFToken(HttpServletRequest request){
        Map<String,String> map = new HashMap<>();
        CsrfToken csrfToken =  (CsrfToken) request.getAttribute("_csrf");
        map.put("csrfToken",csrfToken.getToken());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
