package airlines.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
public class employee {

    @Id
    @GeneratedValue
    @Column(name = "employee_id", nullable = false, unique = true)
    private Integer employee_id;

    @Column(name = "full_name", nullable = false, length = 128)
    private String full_name;

    @Column(name = "birth_date", nullable = false)
    private Date birth_date;

    @Column(name = "passport_data", nullable = false, unique = true, length = 128)
    private String passport_data;

    @Column(name = "email", length = 48)
    private String email;

    @ManyToOne
    @JoinColumn(name = "airport_id", nullable = false)
    private airport airport_id;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private position position_id;

}
