package alatoo.kg.legislations.models.dto;

import alatoo.kg.legislations.models.entities.Legislation;
import lombok.Data;

import javax.persistence.*;
@Data
public class ImageDto {
    private Long id;
    private String uri;
}
