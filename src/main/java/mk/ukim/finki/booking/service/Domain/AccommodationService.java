package mk.ukim.finki.booking.service.Domain;


import mk.ukim.finki.booking.model.domain.Accommodation;

import java.util.List;

public interface AccommodationService {
    List<Accommodation> findAll();

    List<Accommodation> findAllByRented(Boolean rented);

    Accommodation findById(Long id);

    Accommodation create(Accommodation accommodation);

    Accommodation update(Long id, Accommodation accommodation);

    Accommodation delete(Long id);

    Accommodation rent(Long id);
}