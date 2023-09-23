package alatoo.kg.legislations.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "images")
@Data
public class Image {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "uri")
    private String uri;
    @OneToOne
    @JoinColumn(name = "legislations_id")
    private Legislation legislation;
}
