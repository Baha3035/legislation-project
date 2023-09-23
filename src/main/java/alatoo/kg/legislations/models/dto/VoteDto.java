package alatoo.kg.legislations.models.dto;

import lombok.Data;
@Data
public class VoteDto {
    private Long id;
    private UserDto user;
    private LegislationDto legislation;

}
