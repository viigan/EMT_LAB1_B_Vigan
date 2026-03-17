package mk.ukim.finki.booking.service.Application;

import mk.ukim.finki.booking.model.dto.CreateHostDto;
import mk.ukim.finki.booking.model.dto.DisplayHostDto;

import java.util.List;

public interface HostApplicationService {
    List<DisplayHostDto> findAll();

    DisplayHostDto findById(Long id);

    DisplayHostDto create(CreateHostDto createHostDto);

    DisplayHostDto update(Long id, CreateHostDto createHostDto);

    DisplayHostDto delete(Long id);
}