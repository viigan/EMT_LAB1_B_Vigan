package mk.ukim.finki.booking.service.Application;

import mk.ukim.finki.booking.model.dto.CreateCountryDto;
import mk.ukim.finki.booking.model.dto.DisplayCountryDto;

import java.util.List;

public interface CountryApplicationService {
    List<DisplayCountryDto> findAll();

    DisplayCountryDto findById(Long id);

    DisplayCountryDto create(CreateCountryDto createCountryDto);

    DisplayCountryDto update(Long id, CreateCountryDto createCountryDto);

    DisplayCountryDto delete(Long id);
}