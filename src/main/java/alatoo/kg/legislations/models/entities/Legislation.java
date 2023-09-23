package alatoo.kg.legislations.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @OneToOne(mappedBy = "legislation", cascade = CascadeType.ALL)
    private Image image;
    @Column(name = "id_idea")
    private Boolean is_idea;
    @OneToOne(mappedBy = "legislation", cascade = CascadeType.ALL)
    private Tag tag;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "votes_total")
    private Integer votes_total;
}
