package alatoo.kg.legislations.services;

import alatoo.kg.legislations.models.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void saveUser(User user);
    User user getUserById(Long id);
    User user findByEmail(String email);

}
