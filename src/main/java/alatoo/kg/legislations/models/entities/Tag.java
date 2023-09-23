package alatoo.kg.legislations.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tags")
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "legislations_id")
    private Legislation legislation;
}
