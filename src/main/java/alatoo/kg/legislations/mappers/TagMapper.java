package alatoo.kg.legislations.mappers;

import alatoo.kg.legislations.models.dto.TagDto;
import alatoo.kg.legislations.models.entities.Tag;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;
import java.util.stream.Collectors;

public class TagMapper implements BaseMapper<TagDto, Tag>{
    private MapperFacade mapperFacade;

    public TagMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(TagDto.class, Tag.class)
                .byDefault();
        mapperFacade = mapperFactory.getMapperFacade();
    }
    @Override
    public Tag toEntity(TagDto dto) {
        return mapperFacade.map(dto, Tag.class);
    }

    @Override
    public TagDto toDto(Tag entity) {
        return mapperFacade.map(entity, TagDto.class);
    }

    @Override
    public List<Tag> toEntities(List<TagDto> dtoList) {
        return dtoList.stream().map(x->mapperFacade.map(x, Tag.class)).collect(Collectors.toList());
    }

    @Override
    public List<TagDto> toDtoList(List<Tag> entities) {
        return entities.stream().map(x->mapperFacade.map(x, TagDto.class)).collect(Collectors.toList());
    }
}
