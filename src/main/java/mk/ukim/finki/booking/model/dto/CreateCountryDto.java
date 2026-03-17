package mk.ukim.finki.booking.model.dto;

import mk.ukim.finki.booking.model.domain.Country;

public record CreateCountryDto(String name, String continent) {
    public Country toCountry(){
        return  new Country(name,continent);
    }
}
