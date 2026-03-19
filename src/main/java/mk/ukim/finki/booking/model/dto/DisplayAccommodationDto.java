package mk.ukim.finki.booking.model.dto;

import mk.ukim.finki.booking.model.domain.Accommodation;
import mk.ukim.finki.booking.model.enums.Condition;
import mk.ukim.finki.booking.model.enums.Category;
import java.util.List;

public record DisplayAccommodationDto(
        Long id,
        String name,
        Category category,
        Long host_id,
        Condition condition,
        Integer numRooms,
        Boolean rented
) {
    public static DisplayAccommodationDto from(Accommodation accommodation) {
        return new DisplayAccommodationDto(
                accommodation.getId(),
                accommodation.getName(),
                accommodation.getCategory(),
                accommodation.getHost().getId(),
                accommodation.getCondition(),
                accommodation.getNumRooms(),
                accommodation.getRented()
        );
    }

    public static List<DisplayAccommodationDto> from(List<Accommodation> accommodations) {
        return accommodations.stream().map(DisplayAccommodationDto::from).toList();
    }
}