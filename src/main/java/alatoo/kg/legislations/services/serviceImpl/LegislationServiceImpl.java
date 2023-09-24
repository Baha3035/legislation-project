package alatoo.kg.legislations.services.serviceImpl;

import alatoo.kg.legislations.dao.LegislationRepo;
import alatoo.kg.legislations.mappers.LegislationMapper;
import alatoo.kg.legislations.models.dto.LegislationDto;
import alatoo.kg.legislations.models.entities.Legislation;
import alatoo.kg.legislations.services.LegislationService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class LegislationServiceImpl implements LegislationService {
    @Autowired
    private LegislationRepo repo;
 //   private final ImageMapper imageMapper;

    @Override
    public LegislationDto save(LegislationDto legislationDto) {
        return map().toDto(repo.save(map().toEntity(legislationDto)));
    }

    @Override
    public LegislationDto update(LegislationDto legislationDto) {
        return null;
    }

    @Override
    public LegislationDto findById(Long id) {
        return null;
    }

    @Override
    public List<LegislationDto> findAll() {
        return map().toDtoList(repo.findAll());
    }

    LegislationMapper map() {
        return new LegislationMapper();
    }
}
