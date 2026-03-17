package mk.ukim.finki.booking.service.Domain;


import mk.ukim.finki.booking.model.domain.Accomodation;

import java.util.List;

public interface AccommodationService {
    List<Accomodation> findAll();

    List<Accomodation> findAllByRented(Boolean rented);

    Accomodation findById(Long id);

    Accomodation create(Accomodation accommodation);

    Accomodation update(Long id, Accomodation accommodation);

    Accomodation delete(Long id);

    Accomodation rent(Long id);
}