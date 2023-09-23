package alatoo.kg.legislations.mappers;

import alatoo.kg.legislations.models.dto.CommentDto;
import alatoo.kg.legislations.models.dto.UserDto;
import alatoo.kg.legislations.models.dto.VoteDto;
import alatoo.kg.legislations.models.entities.Comment;
import alatoo.kg.legislations.models.entities.User;
import alatoo.kg.legislations.models.entities.Vote;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;
import java.util.stream.Collectors;

public class VoteMapper implements BaseMapper<VoteDto, Vote>{
    private MapperFacade mapperFacade;

    public VoteMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(VoteDto.class, Vote.class)
                .byDefault();
        mapperFacade = mapperFactory.getMapperFacade();
    }
    @Override
    public Vote toEntity(VoteDto dto) {
        return mapperFacade.map(dto, Vote.class);
    }

    @Override
    public VoteDto toDto(Vote entity) {
        return mapperFacade.map(entity, VoteDto.class);
    }

    @Override
    public List<Vote> toEntities(List<VoteDto> dtoList) {
        return dtoList.stream().map(x->mapperFacade.map(x, Vote.class)).collect(Collectors.toList());
    }

    @Override
    public List<VoteDto> toDtoList(List<Vote> entities) {
        return entities.stream().map(x->mapperFacade.map(x, VoteDto.class)).collect(Collectors.toList());
    }
}
