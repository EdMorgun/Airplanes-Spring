package airlines.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
public class client {
    @Id
    @GeneratedValue
    @Column(name = "client_id", nullable = false)
    private Integer client_id;

    @Column(name = "full_name", nullable = false)
    private String full_name;

    @Column(name = "birth_date")
    private Date birth_date;

    @Column(name = "passport_data", unique = true, nullable = false)
    private String passport_data;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "usr_id")
    private Users usr;
}
