package mk.ukim.finki.booking.service.Application.Implementation;

import mk.ukim.finki.booking.model.domain.Country;
import mk.ukim.finki.booking.model.dto.CreateHostDto;
import mk.ukim.finki.booking.model.dto.DisplayHostDto;
import mk.ukim.finki.booking.service.Application.HostApplicationService;
import mk.ukim.finki.booking.service.Domain.CountryService;
import mk.ukim.finki.booking.service.Domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {
    private final HostService hostService;
    private final CountryService countryService;

    public HostApplicationServiceImpl(HostService hostService, CountryService countryService) {
        this.hostService = hostService;
        this.countryService = countryService;
    }


    @Override
    public List<DisplayHostDto> findAll() {
        return DisplayHostDto.from(hostService.findAll());
    }

    @Override
    public DisplayHostDto findById(Long id) {
        return DisplayHostDto.from(hostService.findById(id));

    }

    @Override
    public DisplayHostDto create(CreateHostDto createHostDto) {
        Country country = countryService.findById(createHostDto.countryId());
        return DisplayHostDto.from(hostService.create(createHostDto.toHost(country)));


    }

    @Override
    public DisplayHostDto update(Long id, CreateHostDto createHostDto) {
        Country country = countryService.findById(createHostDto.countryId());
        return DisplayHostDto.from(hostService.update(id, createHostDto.toHost(country)));


    }
    @Override
    public DisplayHostDto delete(Long id) {
        return DisplayHostDto.from(hostService.delete(id));
    }
}
