package pl.niziolekp.app.userservice.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TestController {

    @GetMapping("/for-all")
    public String forall() {
        return "Hello World";
    }
    @GetMapping("/for-user")
    public String forUser() {
        return "for user";
    }
    @GetMapping("/for-admin")
    public String forAdmin() {
        return "for admin";
    }
    @GetMapping("/for-auth")
    public String forAuth() {
        return "for auth";
    }
    @GetMapping("/for-debug")
    public Collection<? extends GrantedAuthority> forDebug() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

}
