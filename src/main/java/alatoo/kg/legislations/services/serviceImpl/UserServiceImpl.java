package alatoo.kg.legislations.services.serviceImpl;

import alatoo.kg.legislations.models.entities.User;
import alatoo.kg.legislations.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(User user) {

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
