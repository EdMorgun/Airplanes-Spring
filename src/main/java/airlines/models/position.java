package airlines.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class position {

    @Id
    @GeneratedValue
    @Column(name = "position_id", nullable = false)
    private Integer position_id;

    @Column(name = "name", length = 64)
    private String name;

    @Column(name = "description", length = 512)
    private String description;



}
