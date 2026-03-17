package mk.ukim.finki.booking.repository;

import mk.ukim.finki.booking.model.domain.Accomodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accomodation,Long> {

    List<Accomodation> findAccomodationsByRented(Boolean rented);
}
