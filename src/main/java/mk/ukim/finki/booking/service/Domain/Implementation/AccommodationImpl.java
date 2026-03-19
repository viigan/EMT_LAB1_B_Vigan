package mk.ukim.finki.booking.service.Domain.Implementation;

import mk.ukim.finki.booking.model.domain.Accommodation;
import mk.ukim.finki.booking.model.exception.AccommodationNotAvailableException;
import mk.ukim.finki.booking.model.exception.AccomodationNotFoundException;
import mk.ukim.finki.booking.repository.AccommodationRepository;
import mk.ukim.finki.booking.service.Domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationImpl implements AccommodationService {
    private  final AccommodationRepository accommodationRepository;

    public AccommodationImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public List<Accommodation> findAll() {
        return this.accommodationRepository.findAll();
    }

    @Override
    public List<Accommodation> findAllByRented(Boolean rented) {
        return this.accommodationRepository.findAccomodationsByRented(rented);
    }

    @Override
    public Accommodation findById(Long id) {
        return this.accommodationRepository.findById(id).orElseThrow(()->new AccomodationNotFoundException(id));
    }

    @Override
    public Accommodation create(Accommodation accommodation) {
        return this.accommodationRepository.save(accommodation);
    }

    @Override
    public Accommodation update(Long id, Accommodation accommodation) {
        Accommodation newAcc =  this.accommodationRepository.findById(id).orElseThrow(()->new AccomodationNotFoundException(id));

        newAcc.setCategory(accommodation.getCategory());
        newAcc.setHost(accommodation.getHost());
        newAcc.setCondition(accommodation.getCondition());
        newAcc.setNumRooms(accommodation.getNumRooms());

        return this.accommodationRepository.save(newAcc);

    }

    @Override
    public Accommodation delete(Long id) {
        Accommodation aa =  this.accommodationRepository.findById(id).orElseThrow(()->new AccomodationNotFoundException(id));
          this.accommodationRepository.delete(aa);
          return aa;
    }

    @Override
    public Accommodation rent(Long id) {
        Accommodation a = this.accommodationRepository.findById(id).orElseThrow( ()->new AccomodationNotFoundException(id));
        if(a.getRented()){
            throw new AccommodationNotAvailableException(id);
        }
        a.setRented(true);
        this.accommodationRepository.save(a);
        return a;
    }
}
