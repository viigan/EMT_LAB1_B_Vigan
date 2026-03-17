package mk.ukim.finki.booking.model.exception;

public class AccomodationNotFoundException extends RuntimeException {
    public AccomodationNotFoundException(Long id) {
        super("Accommodation with id %d does not exist.".formatted(id));
    }
}

