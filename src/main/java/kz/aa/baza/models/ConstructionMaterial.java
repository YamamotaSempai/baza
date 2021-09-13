package kz.aa.baza.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "constructor_materials")
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

    @Column(name = "updated_by")
    private Long updatedBy;

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

    @Column(name = "city_id", nullable = false) private Long cityId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public ConstructionMaterial() {
    }

    @Builder
    public ConstructionMaterial(String title, String description, String address, double price, Long cityId, Category category) {
        this.title = title;
        this.description = description;
        this.address = address;
        this.price = price;
        this.cityId = cityId;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ConstructionMaterial that = (ConstructionMaterial) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 654229355;
    }
}