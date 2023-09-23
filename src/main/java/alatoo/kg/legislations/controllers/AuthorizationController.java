package alatoo.kg.legislations.controllers;

import alatoo.kg.legislations.config.JWTGenerator;
import alatoo.kg.legislations.dao.RoleRepo;
import alatoo.kg.legislations.dao.UserRepo;
import alatoo.kg.legislations.models.dto.AuthResponseDTO;
import alatoo.kg.legislations.models.dto.LoginDTO;
import alatoo.kg.legislations.models.dto.RoleDto;
import alatoo.kg.legislations.models.dto.UserDto;
import alatoo.kg.legislations.models.entities.Role;
import alatoo.kg.legislations.models.entities.User;
import alatoo.kg.legislations.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

@RestController
@RequestMapping("/api/auth")
public class AuthorizationController {

    private AuthenticationManager authenticationManager;
    private UserService userService;
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    public AuthorizationController(
            AuthenticationManager authenticationManager, UserRepo userRepo,
            UserService userService,
            RoleRepo roleRepo, PasswordEncoder passwordEncoder,
            JWTGenerator jwtGenerator){
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.userService = userService;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return ResponseEntity.ok("Registered");
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO login){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

}
