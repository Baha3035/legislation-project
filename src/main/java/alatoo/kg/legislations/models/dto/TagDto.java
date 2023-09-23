package alatoo.kg.legislations.models.dto;

import lombok.Data;

@Data
public class TagDto {
    private Long id;
    private String name;
    private LegislationDto legislation;
}
