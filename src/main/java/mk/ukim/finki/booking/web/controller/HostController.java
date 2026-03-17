package mk.ukim.finki.booking.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.booking.model.dto.CreateCountryDto;
import mk.ukim.finki.booking.model.dto.CreateHostDto;
import mk.ukim.finki.booking.model.dto.DisplayCountryDto;
import mk.ukim.finki.booking.model.dto.DisplayHostDto;
import mk.ukim.finki.booking.service.Application.HostApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hosts")
public class HostController {
    private final HostApplicationService hostApplicationService;

    public HostController(HostApplicationService hostApplicationService) {
        this.hostApplicationService = hostApplicationService;
    }


    @GetMapping
    public ResponseEntity<List<DisplayHostDto>> findAll() {
        return ResponseEntity.ok(hostApplicationService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DisplayHostDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(hostApplicationService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayHostDto> create(@RequestBody @Valid CreateHostDto dto) {
        return ResponseEntity.ok(hostApplicationService.create(dto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayHostDto> update( @PathVariable Long id,@RequestBody @Valid CreateHostDto dto) {

        return ResponseEntity.ok(hostApplicationService.update(id,dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DisplayHostDto> delete(@PathVariable Long id) {

        return ResponseEntity.ok(hostApplicationService.delete(id));
    }

}
