package alatoo.kg.legislations.dao;
import alatoo.kg.legislations.models.entities.User;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmail(String email);

}


