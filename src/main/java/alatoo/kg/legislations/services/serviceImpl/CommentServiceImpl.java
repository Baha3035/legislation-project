package alatoo.kg.legislations.services.serviceImpl;

import alatoo.kg.legislations.dao.CommentRepo;
import alatoo.kg.legislations.mappers.CommentMapper;
import alatoo.kg.legislations.models.dto.CommentDto;
import alatoo.kg.legislations.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo repo;
    @Override
    public CommentDto save(CommentDto commentDto) {
        return map().toDto(repo.save(map().toEntity(commentDto)));
    }

    @Override
    public CommentDto update(CommentDto commentDto) {
        return null;
    }

    @Override
    public CommentDto findById(Long id) {
        return null;
    }

    @Override
    public List<CommentDto> findAll() {
        return map().toDtoList(repo.findAll());
    }

    CommentMapper map() {
        return new CommentMapper();
    }
}
