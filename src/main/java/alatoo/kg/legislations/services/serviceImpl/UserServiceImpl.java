package alatoo.kg.legislations.services.serviceImpl;

import alatoo.kg.legislations.dao.UserRepo;
import alatoo.kg.legislations.dto.auth.AuthenticationRequest;
import alatoo.kg.legislations.dto.auth.AuthenticationResponse;
import alatoo.kg.legislations.dto.auth.user.UserRequest;
import alatoo.kg.legislations.dto.auth.user.UserResponse;
import alatoo.kg.legislations.enums.Role;

import alatoo.kg.legislations.jwt.JwtTokenProvider;

import alatoo.kg.legislations.models.dto.UserDto;
import alatoo.kg.legislations.models.entities.User;
import alatoo.kg.legislations.services.UserService;
import lombok.AllArgsConstructor;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Base64;
import java.util.Optional;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepo userRepository;
    private final AuthenticationManager authenticationManager;




    private UserRepo userRepo;

    @Override
    public User getUsernameFromToken(String token) {

        String[] chunks = token.substring(7).split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();

        JSONParser jsonParser = new JSONParser();
        JSONObject object = null;
        try {
            object = (JSONObject) jsonParser.parse(decoder.decode(chunks[1]));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return userRepository.findByEmail(String.valueOf(object.get("sub"))).orElseThrow(() -> new alatoo.kg.legislations.exception.BadCredentialsException("user can be null"));
    }



    @Override
    public UserDto saveUser(UserDto userDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> registerUser(UserRequest request) {
        User user = new User();
        if (request.getEmail().contains("@")) {
            user.setEmail(request.getEmail());
        }
        if (request.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());


        user.setRole(Role.USER);
        userRepository.save(user);

        return ResponseEntity.ok(convertAuthentication(user));
    }

    @Override
    public ResponseEntity<?> adminRegister(UserRequest request) {
        User user = new User();
        if (request.getEmail().contains("@")) {
            user.setEmail(request.getEmail());
        }
        if (request.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());


        user.setRole(Role.ADMIN);
        userRepository.save(user);

        return ResponseEntity.ok(convertAuthentication(user));
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Optional<User> optionalAuth = userRepository.findByEmail(request.getEmail());
        if (optionalAuth.isEmpty()) {
            throw new alatoo.kg.legislations.exception.BadCredentialsException("User not found with email: " + request.getEmail());
        }

        User auth = optionalAuth.get();

        userRepository.save(auth);



        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()));
        } catch (AuthenticationException e) {
            // Обработка ошибки аутентификации, например, неверный email или пароль
            throw new BadCredentialsException("Authentication failed: " + e.getMessage() + request.getEmail());
        }

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new alatoo.kg.legislations.exception.BadCredentialsException("User not found"));
        String token = jwtTokenProvider.createToken(user.getEmail(), userRepository.findByEmail(user.getEmail()).get().getRole());

// Obtain WebSocket session for the authenticated user




        return AuthenticationResponse.builder()
                .user(convertToresponse(user))
                .accessToken(token)
                .build();
    }


    private AuthenticationResponse convertAuthentication(User user) {
        AuthenticationResponse response = new AuthenticationResponse();
        response.setUser(convertToresponse(user));
        System.out.println("the user email:" +user.getEmail());
        String token = jwtTokenProvider.createToken(user.getEmail(), Role.USER);
        response.setAccessToken(token);
        return response;
    }

    private UserResponse convertToresponse(User user) {
            UserResponse userResponse = new UserResponse();

            userResponse.setId(user.getId());
            userResponse.setFirstname(user.getFirstname());
            userResponse.setLastname(user.getLastname());
            userResponse.setEmail(user.getEmail());
            userResponse.setRole(user.getRole());
            return userResponse;

    }



}
