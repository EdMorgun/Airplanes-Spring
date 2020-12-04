package airlines.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class spec_machinery_codelist {
    @Id
    @GeneratedValue
    @Column(name = "type_code", nullable = false, unique = true)
    private Integer type_code;

    @Column(name = "type_description", nullable = false)
    private String type_description;

}
