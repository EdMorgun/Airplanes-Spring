package airlines.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class spec_machinery {
    @Id
    @GeneratedValue
    @Column(name = "spec_machinery_id", unique = true, nullable = false)
    private Integer spec_machinery_id;

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @ManyToOne
    @JoinColumn(name = "airport_id", nullable = false)
    private airport airport_id;

    @OneToOne
    @JoinColumn(name = "type_code", nullable = false)
    private spec_machinery_codelist type_code;

}
