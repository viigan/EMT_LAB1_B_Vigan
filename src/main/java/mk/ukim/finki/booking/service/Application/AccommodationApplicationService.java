package mk.ukim.finki.booking.service.Application;


import mk.ukim.finki.booking.model.dto.CreateAccomodationDto;
import mk.ukim.finki.booking.model.dto.DisplayAccommodationDto;

import java.util.List;

public interface AccommodationApplicationService {
    List<DisplayAccommodationDto> findAll();

    List<DisplayAccommodationDto> findAllByRented(Boolean rented);

    DisplayAccommodationDto findById(Long id);

    DisplayAccommodationDto create(CreateAccomodationDto createAccommodationDto);

    DisplayAccommodationDto update(Long id, CreateAccomodationDto createAccommodationDto);

    DisplayAccommodationDto delete(Long id);

    DisplayAccommodationDto rent(Long id);
}