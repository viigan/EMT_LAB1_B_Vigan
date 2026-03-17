package mk.ukim.finki.booking.web.controller;


import jakarta.validation.Valid;
import mk.ukim.finki.booking.model.dto.CreateCountryDto;
import mk.ukim.finki.booking.model.dto.DisplayCountryDto;
import mk.ukim.finki.booking.service.Application.CountryApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/countries")
public class CountryController {
    private final CountryApplicationService countryApplicationService;

    public CountryController(CountryApplicationService countryApplicationService) {
        this.countryApplicationService = countryApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayCountryDto>> findAll() {
       return ResponseEntity.ok(countryApplicationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayCountryDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(countryApplicationService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayCountryDto> create(@RequestBody @Valid CreateCountryDto dto) {
        return ResponseEntity.ok(countryApplicationService.create(dto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayCountryDto> update( @PathVariable Long id,@RequestBody @Valid CreateCountryDto dto) {

        return ResponseEntity.ok(countryApplicationService.update(id,dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DisplayCountryDto> delete(@PathVariable Long id) {

        return ResponseEntity.ok(countryApplicationService.delete(id));
    }


}
