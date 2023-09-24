package alatoo.kg.legislations.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
public class LegislationDto {
    private Long id;
    private UserDto user;
    private String description;
    private String solution;
    private String title;
    private Collection<ImageDto> images;
    private Boolean is_idea;
    private TagDto tag;
    private LocalDateTime date;
    private Integer votes_total;
}
