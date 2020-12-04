package airlines.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ticket {

    @Id
    @GeneratedValue
    @Column(name = "ticket_id", unique = true, nullable = false)
    private Integer ticket_id;

    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private client client;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private route route;

}
