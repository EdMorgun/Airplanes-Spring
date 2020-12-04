package airlines.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class route {
    @Id
    @GeneratedValue
    @Column(name = "route_id", unique = true, nullable = false)
    private Integer route_id;

    @Column(name = "start_cost", nullable = false)
    private Integer start_cost;

    @ManyToOne
    @JoinColumn(name = "source_airport_id", nullable = false)
    private airport source_airport_id;

    @ManyToOne
    @JoinColumn(name = "dest_airport_id", nullable = false)
    private airport dest_airport_id;

    @Column(name = "time_start",nullable = false)
    private Timestamp time_start;

    @Column(name = "time_end", nullable = false)
    private Timestamp time_end;

    @Column(name = "sold")
    private Integer sold;

    @ManyToOne
    @JoinColumn(name = "plane_id", nullable = false)
    private plane plane_id;

}
