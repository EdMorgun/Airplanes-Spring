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
public class ad_service_code {

    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private Integer ad_code_id;

    @Column(name = "descr", nullable = false)
    private String descr;

    @Column(name = "cost", nullable = false)
    private Integer cost;
}
