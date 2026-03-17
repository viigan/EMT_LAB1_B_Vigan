package mk.ukim.finki.booking.model.dto;

import mk.ukim.finki.booking.model.domain.Country;
import mk.ukim.finki.booking.model.domain.Host;

public record CreateHostDto(
        String name,
        String surname,
        Long countryId) {

    public Host toHost(Country country){
    return new Host(name,surname,country);
    }
}
