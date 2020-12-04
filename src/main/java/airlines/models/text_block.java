package airlines.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class text_block {
    @Id
    @GeneratedValue
    @Column(name = "text_block_id", nullable = false, unique = true)
    private Integer text_block_id;

    @Column(name = "text", nullable = false, length = 10000)
    private String text;

    @Column(name = "order_num", nullable = false)
    private Integer order_num;

    @OneToOne
    @JoinColumn(name = "post_id", nullable = false)
    private post post_id;

}
