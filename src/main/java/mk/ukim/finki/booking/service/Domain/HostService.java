package mk.ukim.finki.booking.service.Domain;

import mk.ukim.finki.booking.model.domain.Host;

import java.util.List;

public interface HostService {
    List<Host> findAll();

    Host findById(Long id);

    Host create(Host host);

    Host update(Long id, Host host);

    Host delete(Long id);
}
