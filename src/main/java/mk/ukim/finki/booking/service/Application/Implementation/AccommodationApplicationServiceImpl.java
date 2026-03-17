package mk.ukim.finki.booking.service.Application.Implementation;

import mk.ukim.finki.booking.model.domain.Host;
import mk.ukim.finki.booking.model.dto.CreateAccomodationDto;
import mk.ukim.finki.booking.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.booking.service.Application.AccommodationApplicationService;
import mk.ukim.finki.booking.service.Domain.AccommodationService;
import mk.ukim.finki.booking.service.Domain.HostService;

import java.util.List;

public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {
    private  final AccommodationService accommodationService;
    private final HostService hostService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService, HostService hostService) {
        this.accommodationService = accommodationService;
        this.hostService = hostService;
    }


    @Override
    public List<DisplayAccommodationDto> findAll() {
        return DisplayAccommodationDto.from(accommodationService.findAll());
    }

    @Override
    public List<DisplayAccommodationDto> findAllByRented(Boolean rented) {
        return DisplayAccommodationDto.from(accommodationService.findAllByRented(rented));
    }

    @Override
    public DisplayAccommodationDto findById(Long id) {
        return DisplayAccommodationDto.from(accommodationService.findById(id));

    }

    @Override
    public DisplayAccommodationDto create(CreateAccomodationDto createAccommodationDto) {
        Host host  = hostService.findById(createAccommodationDto.hostId());
        return DisplayAccommodationDto.from(accommodationService.create(createAccommodationDto.toAccomodation(host)));
    }

    @Override
    public DisplayAccommodationDto update(Long id, CreateAccomodationDto createAccommodationDto) {
        Host host = hostService.findById(id);
        return DisplayAccommodationDto.from(accommodationService.update(id,createAccommodationDto.toAccomodation(host)));
    }

    @Override
    public DisplayAccommodationDto delete(Long id) {
     return DisplayAccommodationDto.from(accommodationService.delete(id));
    }

    @Override
    public DisplayAccommodationDto rent(Long id) {
        return DisplayAccommodationDto.from(accommodationService.delete(id));
    }
}
