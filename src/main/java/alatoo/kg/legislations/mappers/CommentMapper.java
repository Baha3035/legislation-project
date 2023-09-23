package alatoo.kg.legislations.mappers;

import alatoo.kg.legislations.models.dto.CommentDto;
import alatoo.kg.legislations.models.entities.Comment;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CommentMapper implements BaseMapper<CommentDto, Comment>{
    private MapperFacade mapperFacade;

    public CommentMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder().build();

        mapperFactory.classMap(CommentDto.class, Comment.class)
                .byDefault();
        mapperFacade = mapperFactory.getMapperFacade();
    }
    @Override
    public Comment toEntity(CommentDto dto) {
        return mapperFacade.map(dto, Comment.class);
    }

    @Override
    public CommentDto toDto(Comment entity) {
        return mapperFacade.map(entity, CommentDto.class);
    }

    @Override
    public List<Comment> toEntities(List<CommentDto> dtoList) {
        return dtoList.stream().map(x->mapperFacade.map(x, Comment.class)).collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> toDtoList(List<Comment> entities) {
        return entities.stream().map(x->mapperFacade.map(x, CommentDto.class)).collect(Collectors.toList());
    }
}
