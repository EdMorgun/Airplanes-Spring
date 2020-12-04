package airlines.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ad_service {

    @Id
    @GeneratedValue
    @Column(name = "ad_service_id", unique = true, nullable = false)
    private Integer ad_service_id;

    @ManyToOne
    @JoinColumn(name = "ad_code_id", nullable = false)
    private ad_service_code ad_code_id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private ticket ticket_id;
}
