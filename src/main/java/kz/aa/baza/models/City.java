package kz.aa.baza.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "city")
public class City {

    @JsonIgnore
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITY_SEQ")
    @SequenceGenerator(name = "CITY_SEQ", sequenceName = "CITY_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        City city = (City) o;

        return Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
        return 39525063;
    }
}
