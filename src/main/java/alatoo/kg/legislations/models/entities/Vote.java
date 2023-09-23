package alatoo.kg.legislations.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "votes")
@Data
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "legislations_id")
    private Legislation legislation;

}
