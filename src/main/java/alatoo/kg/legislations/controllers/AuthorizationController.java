package alatoo.kg.legislations.controllers;

import alatoo.kg.legislations.dao.UserRepo;
import alatoo.kg.legislations.dto.auth.AuthenticationRequest;
import alatoo.kg.legislations.dto.auth.user.UserRequest;
import alatoo.kg.legislations.jwt.JwtTokenProvider;
import alatoo.kg.legislations.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthorizationController {

    private AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    private final UserService service;

    @PostMapping("/register/user")
    public ResponseEntity<?> jobSeekerRegister(@RequestBody UserRequest request) {
        System.out.println(request.getEmail());
        return service.registerUser(request);
    }

    @PostMapping("/register/admin")
    public ResponseEntity<?> adminRegister(@RequestBody UserRequest request) {
        return service.adminRegister(request);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

}
