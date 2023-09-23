package alatoo.kg.legislations.services;

import alatoo.kg.legislations.models.dto.UserDto;
import alatoo.kg.legislations.models.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto saveUser(UserDto userDto);

}
