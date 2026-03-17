package mk.ukim.finki.booking.service.Domain.Implementation;

import mk.ukim.finki.booking.model.domain.Country;
import mk.ukim.finki.booking.model.exception.AccomodationNotFoundException;
import mk.ukim.finki.booking.repository.CountryRepository;
import mk.ukim.finki.booking.service.Domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private  final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id).orElseThrow(()-> new AccomodationNotFoundException(id));
    }

    @Override
    public Country create(Country country) {
        return this.countryRepository.save(country);
    }

    @Override
    public Country update(Long id, Country country) {
       Country c = this.countryRepository.findById(id).orElseThrow(()-> new AccomodationNotFoundException(id));

       c.setContinent(country.getContinent());
       c.setName(country.getName());

       this.countryRepository.save(c);

       return c;

    }

    @Override
    public Country delete(Long id) {
        Country c = this.countryRepository.findById(id).orElseThrow(()-> new AccomodationNotFoundException(id));

        this.countryRepository.delete(c);
        return c;
    }
}
