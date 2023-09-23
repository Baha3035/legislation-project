package alatoo.kg.legislations.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    @Column(name = "date")
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "legislations_id")
    private Legislation legislation;
    @Column(name = "content")
    private String content;
}
