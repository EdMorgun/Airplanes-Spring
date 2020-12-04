package airlines.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class airport {
    @Id
    @GeneratedValue
    private Integer airport_id;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

}
