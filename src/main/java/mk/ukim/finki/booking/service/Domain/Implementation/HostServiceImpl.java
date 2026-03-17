package mk.ukim.finki.booking.service.Domain.Implementation;

import mk.ukim.finki.booking.model.domain.Host;
import mk.ukim.finki.booking.model.exception.AccomodationNotFoundException;
import mk.ukim.finki.booking.repository.HostRepository;
import mk.ukim.finki.booking.service.Domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Host> findAll() {
       return this.hostRepository.findAll();
    }

    @Override
    public Host findById(Long id) {
      return this.hostRepository.findById(id).orElseThrow(()->new AccomodationNotFoundException(id));
    }

    @Override
    public Host create(Host host) {

        return this.hostRepository.save(host);
    }

    @Override
    public Host update(Long id, Host host) {

        Host hostExists = hostRepository.findById(id)
                .orElseThrow(() -> new AccomodationNotFoundException( id));

        hostExists.setName(host.getName());
        hostExists.setSurname(host.getSurname());
        hostExists.setCountry(host.getCountry());
        return this.hostRepository.save(hostExists);

    }

    @Override
    public Host delete(Long id) {
        Host hostExists = hostRepository.findById(id)
                .orElseThrow(() -> new AccomodationNotFoundException( id));

         this.hostRepository.delete(hostExists);
         return hostExists;

    }
}
