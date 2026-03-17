package mk.ukim.finki.booking.service.Domain;

import mk.ukim.finki.booking.model.domain.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll();

    Country findById(Long id);

    Country create(Country country);

    Country update(Long id, Country country);

    Country delete(Long id);
}
