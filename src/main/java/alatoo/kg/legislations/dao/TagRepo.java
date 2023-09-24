package alatoo.kg.legislations.dao;
import alatoo.kg.legislations.models.entities.Legislation;
import alatoo.kg.legislations.models.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepo extends JpaRepository<Tag,Long> {
    List<Legislation> findLegislationsById(Long id); // Sultan should make ManyToOne
}
