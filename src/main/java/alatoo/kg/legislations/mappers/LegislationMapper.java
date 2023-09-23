package alatoo.kg.legislations.mappers;

import alatoo.kg.legislations.models.dto.CommentDto;
import alatoo.kg.legislations.models.dto.LegislationDto;
import alatoo.kg.legislations.models.entities.Comment;
import alatoo.kg.legislations.models.entities.Legislation;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class LegislationMapper implements BaseMapper<LegislationDto, Legislation>{
    private MapperFacade mapperFacade;

    public LegislationMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(LegislationDto.class, Legislation.class)
                .byDefault();
        mapperFacade = mapperFactory.getMapperFacade();
    }
    @Override
    public Legislation toEntity(LegislationDto dto) {
        return mapperFacade.map(dto, Legislation.class);
    }

    @Override
    public LegislationDto toDto(Legislation entity) {
        return mapperFacade.map(entity, LegislationDto.class);
    }

    @Override
    public List<Legislation> toEntities(List<LegislationDto> dtoList) {
        return dtoList.stream().map(x->mapperFacade.map(x, Legislation.class)).collect(Collectors.toList());
    }

    @Override
    public List<LegislationDto> toDtoList(List<Legislation> entities) {
        return entities.stream().map(x->mapperFacade.map(x, LegislationDto.class)).collect(Collectors.toList());
    }
}
