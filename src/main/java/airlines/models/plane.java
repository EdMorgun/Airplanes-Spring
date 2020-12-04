package airlines.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
public class plane {
    @Id
    @GeneratedValue
    private Integer plane_id;

    @Column(name ="number", unique = true, nullable = false)
    private String number;

    @ManyToOne
    @JoinColumn(name = "hangar_id", nullable = false)
    private hangar hangar_id;

    @Column(name = "model", length = 32, nullable = false)
    private String model;

    @Column(name = "last_maintenance", nullable = false)
    private Date last_maintenance;

    @Column(name = "resource", nullable = false)
    private Integer resource;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

}
