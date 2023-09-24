package alatoo.kg.legislations.services.serviceImpl;

import alatoo.kg.legislations.dao.VoteRepo;
import alatoo.kg.legislations.mappers.VoteMapper;
import alatoo.kg.legislations.models.dto.VoteDto;
import alatoo.kg.legislations.services.BaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoteServiceImpl implements BaseCrudService<VoteDto, Long> {
    @Autowired
    private VoteRepo repo;
    @Override
    public VoteDto save(VoteDto voteDto) {
        return map().toDto(repo.save(map().toEntity(voteDto)));
    }

    @Override
    public VoteDto update(VoteDto voteDto) {
        return null;
    }

    @Override
    public VoteDto findById(Long id) {
        return null;
    }

    @Override
    public List<VoteDto> findAll() {
        return map().toDtoList(repo.findAll());
    }

    private VoteMapper map() {
        return new VoteMapper();
    }
}
