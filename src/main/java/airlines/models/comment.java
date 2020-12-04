package airlines.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class comment {
    @Id
    @GeneratedValue
    @Column(name = "comment_id", unique = true, nullable = false)
    private Integer comment_id;

    @ManyToOne
    @JoinColumn(name="feedback_id", nullable = false)
    private feedback feedback_id;

    @Column(name = "like_amount", nullable = false)
    private Integer like_amount;

    @Column(name = "dislike_amount", nullable = false)
    private Integer dislike_amount;

    @Column(name = "text", length = 512, nullable = false)
    private String text;
}
