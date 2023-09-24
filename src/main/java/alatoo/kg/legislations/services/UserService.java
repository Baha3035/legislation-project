package alatoo.kg.legislations.services;

import alatoo.kg.legislations.dto.auth.AuthenticationRequest;
import alatoo.kg.legislations.dto.auth.user.UserRequest;
import alatoo.kg.legislations.models.dto.UserDto;
import alatoo.kg.legislations.models.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    User getUsernameFromToken(String token);

    UserDto saveUser(UserDto userDto);

    ResponseEntity<?> registerUser(UserRequest request);

    ResponseEntity<?> adminRegister(UserRequest request);

    Object authenticate(AuthenticationRequest request);
}
