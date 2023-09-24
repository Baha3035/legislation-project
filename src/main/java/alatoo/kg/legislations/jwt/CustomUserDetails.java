package alatoo.kg.legislations.jwt;

import alatoo.kg.legislations.dao.UserRepo;
import alatoo.kg.legislations.models.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomUserDetails implements UserDetailsService {
    private final UserRepo authRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> auth = authRepository.findByEmail(email);

        if (auth.isEmpty()) {
            throw new UsernameNotFoundException("User '" + email + "' not found");
        }
        User user = auth.get();
        return org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRole().name())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
