package alatoo.kg.legislations.dto.auth.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
