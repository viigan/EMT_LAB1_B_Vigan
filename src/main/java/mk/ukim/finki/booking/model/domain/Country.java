package mk.ukim.finki.booking.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mk.ukim.finki.booking.model.domain.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "countries")
public class Country extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String continent;

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}