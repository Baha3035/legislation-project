package alatoo.kg.legislations.dao;

import alatoo.kg.legislations.models.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepo extends JpaRepository<Vote,Long> {
}
