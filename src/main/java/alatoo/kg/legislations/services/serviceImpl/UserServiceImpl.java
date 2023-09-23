package alatoo.kg.legislations.services.serviceImpl;

import alatoo.kg.legislations.dao.UserRepo;
import alatoo.kg.legislations.mappers.UserMapper;
import alatoo.kg.legislations.models.dto.RoleDto;
import alatoo.kg.legislations.models.dto.UserDto;
import alatoo.kg.legislations.models.entities.Role;
import alatoo.kg.legislations.models.entities.User;
import alatoo.kg.legislations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {


    private UserRepo userRepo;
    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        userDto.setUserRole("USER");
        return map().toDto(userRepo.save(map().toEntity(userDto)));
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), mapRolesToAuthorities(user.getUserRole()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    UserMapper map(){
        return new UserMapper();
    }


}
