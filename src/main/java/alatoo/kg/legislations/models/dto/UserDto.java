package alatoo.kg.legislations.models.dto;
import lombok.Data;

import java.util.Collection;
@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Collection<RoleDto> userRole;
}
