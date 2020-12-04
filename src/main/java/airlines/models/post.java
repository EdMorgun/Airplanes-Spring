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
public class post {
    @Id
    @GeneratedValue
    @Column(name = "post_id", nullable = false, unique = true)
    private Integer post_id;

    @Column(name = "theme", nullable = false)
    private String theme;
}
