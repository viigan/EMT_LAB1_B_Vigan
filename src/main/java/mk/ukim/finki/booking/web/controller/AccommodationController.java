package mk.ukim.finki.booking.web.controller;


import jakarta.validation.Valid;
import mk.ukim.finki.booking.model.dto.CreateAccomodationDto;
import mk.ukim.finki.booking.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.booking.model.dto.DisplayCountryDto;
import mk.ukim.finki.booking.service.Application.AccommodationApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/accommodations")
public class AccommodationController {
    private final AccommodationApplicationService accommodationApplicationService;


    public AccommodationController(AccommodationApplicationService accommodationApplicationService) {
        this.accommodationApplicationService = accommodationApplicationService;
    }
    @GetMapping
    public ResponseEntity<List<DisplayAccommodationDto>> findAll() {
        return ResponseEntity.ok(accommodationApplicationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayAccommodationDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(accommodationApplicationService.findById(id));
    }


    @PostMapping("/add")
    public ResponseEntity<DisplayAccommodationDto> create(@RequestBody @Valid CreateAccomodationDto dto) {
        return ResponseEntity.ok(accommodationApplicationService.create(dto));

    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayAccommodationDto> update(
            @PathVariable Long id,
            @RequestBody @Valid CreateAccomodationDto dto) {
        return ResponseEntity.ok(accommodationApplicationService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DisplayAccommodationDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(accommodationApplicationService.delete(id));
    }



}
