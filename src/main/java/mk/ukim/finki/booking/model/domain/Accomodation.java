package mk.ukim.finki.booking.model.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mk.ukim.finki.booking.model.enums.Category;
import mk.ukim.finki.booking.model.enums.Condition;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Accomodation extends BaseAuditableEntity {
//    Во рамки на апликацијата се чуваат следните податоци за сместувањата:
//    id (Long), createdAt (LocalDateTime), updatedAt (LocalDateTime),
//    name (String), category (enum), host (Host) и numRooms (Integer).

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Host host;

    @Column(nullable = false)
    private Integer numRooms;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Condition condition = Condition.GOOD;

    @Column(nullable = false)
    private Boolean rented = Boolean.FALSE;



    public Accomodation(String name, Category category, Host host, Integer numRooms, Condition condition,Boolean rented) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.condition = condition;
        this.rented= rented;
    }

    //this is used when we want to create new accomodation!
    public Accomodation(String name, Category category, Host host, Integer numRooms, Condition condition) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.condition = condition;
    }

}
