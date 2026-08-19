package io.github.cupokki.chatkiosk26.store.dto;

public class StoreDto {

    public record DetailResponse(
            Long id,
            String name,
            String detail
    ) {
    }
}
