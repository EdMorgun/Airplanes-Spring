package airlines.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class hangar {
    @Id
    @GeneratedValue
    private Integer hangar_id;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "number", length = 5, nullable = false)
    private String number;

    @ManyToOne
    @JoinColumn(name = "airport_id", nullable = false)
    private airport airport_id;

}
