package alatoo.kg.legislations.services;

import alatoo.kg.legislations.models.dto.LegislationDto;
import alatoo.kg.legislations.models.dto.TagDto;

import java.util.List;

public interface TagService extends BaseCrudService<TagDto, Long> {
    List<LegislationDto> findLegislationDtosByTagId(Long id);
}