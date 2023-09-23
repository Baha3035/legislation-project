package alatoo.kg.legislations.models.dto;

import java.time.LocalDateTime;

public class LegislationDto {
    private Long id;
    private UserDto user;
    private String description;
    private String solution;
    private String title;
    private ImageDto image;
    private Boolean is_idea;
    private TagDto tag;
    private LocalDateTime date;
    private Integer votes_total;
}
