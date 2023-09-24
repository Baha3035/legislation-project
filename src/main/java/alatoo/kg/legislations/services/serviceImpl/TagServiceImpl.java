package alatoo.kg.legislations.services.serviceImpl;

import alatoo.kg.legislations.dao.TagRepo;
import alatoo.kg.legislations.mappers.LegislationMapper;
import alatoo.kg.legislations.mappers.TagMapper;
import alatoo.kg.legislations.models.dto.LegislationDto;
import alatoo.kg.legislations.models.dto.TagDto;
import alatoo.kg.legislations.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepo repo;
    @Override
    public TagDto save(TagDto tagDto) {
        return map().toDto(map().toEntity(tagDto));
    }

    @Override
    public TagDto update(TagDto tagDto) {
        return null;
    }

    @Override
    public TagDto findById(Long id) {
        return null;
    }

    @Override
    public List<TagDto> findAll() {
        return map().toDtoList(repo.findAll());
    }

    TagMapper map() {
        return new TagMapper();
    }

    LegislationMapper mapLegislation() {
        return new LegislationMapper();
    }

    @Override
    public List<LegislationDto> findLegislationDtosByTagId(Long id) {
        return mapLegislation().toDtoList(repo.findLegislationsById(id));
    }
}
