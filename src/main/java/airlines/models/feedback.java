package airlines.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class feedback {
    @Id
    @GeneratedValue
    @Column(name = "feedback_id", unique = true, nullable = false)
    private Integer feedback_id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private client client_id;

    @Column(name = "like_amount", nullable = false)
    private Integer like_amount;

    @Column(name = "dislike_amount", nullable = false)
    private Integer dislike_amount;

    @Column(name ="text", nullable = false)
    private String text;

    @Column(name = "theme", nullable = false)
    private String theme;

    @OneToOne
    @JoinColumn(name = "post_id", nullable = false)
    private post post_id;



}
