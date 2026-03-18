package mk.ukim.finki.booking.model.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@Entity
public class Host extends BaseAuditableEntity{
    // id (Long), createdAt (LocalDateTime),
    // updatedAt (LocalDateTime), name (String),
    // surname (String) и country (Country).

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String surname;

    @ManyToOne
    private  Country country;

    public Host(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
