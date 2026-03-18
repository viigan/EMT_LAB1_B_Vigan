package mk.ukim.finki.booking.model.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import mk.ukim.finki.booking.model.domain.Accomodation;
import mk.ukim.finki.booking.model.domain.Host;
import mk.ukim.finki.booking.model.enums.Category;
import mk.ukim.finki.booking.model.enums.Condition;

public record CreateAccomodationDto(
        @NotBlank(message = "A name is required.")
        String name,
        Category category,
        Long hostId,
        @Positive
        Integer numRooms,
        Condition condition

) {
    public Accomodation toAccomodation(Host host) {
        return new Accomodation(name,category,host,numRooms,condition);
    }
}