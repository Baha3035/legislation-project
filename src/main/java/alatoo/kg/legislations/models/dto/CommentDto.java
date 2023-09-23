package alatoo.kg.legislations.models.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CommentDto {
    private Long id;
    private UserDto user;
    private LocalDateTime date;
    private LegislationDto legislation;
    private String content;
}
