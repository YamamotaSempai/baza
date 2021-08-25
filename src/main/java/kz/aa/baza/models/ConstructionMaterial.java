package kz.aa.baza.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "constructor_material")
public class ConstructionMaterial {

    @JsonIgnore
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ")
    @SequenceGenerator(name = "ITEM_SEQ", sequenceName = "ITEM_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "author")
    @NotNull
    private Long author;

    @Column(name = "title", length = 100)
    @NotNull
    private String title;

    @Column(name = "created_date")
    @NotNull
    private LocalDateTime createdDate;

    @Column(name = "description", length = 500)
    @NotNull
    private String description;

    @Column(name = "ADDRESS", length = 100)
    @NotNull
    private String address;

//    private List<String> photos;     // TODO: 24.08.2021 add category & photos

    @Column(name = "PRICE")
    @NotNull
    private double price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}