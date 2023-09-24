package alatoo.kg.legislations.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "legislations")
@Data
public class Legislation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    @Column(name = "description")
    private String description;
    @Column(name = "solution")
    private String solution;
    @Column(name = "title")
    private String title;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private Collection<Image> images;
    @Column(name = "is_idea")
    private Boolean is_idea;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "votes_total")
    private Integer votes_total;
}
