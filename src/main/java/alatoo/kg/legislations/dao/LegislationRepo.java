package alatoo.kg.legislations.dao;

import alatoo.kg.legislations.models.entities.Legislation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LegislationRepo extends JpaRepository<Legislation,Long> {

    List<Legislation> findByTile(String title);
    List<Legislation> findByDate(LocalDateTime dateTime);

}
