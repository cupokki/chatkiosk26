package io.github.cupokki.chatkiosk26.menu.dto;

public class MenuDto {

    public record StoreMenusResponse(
            Long id,
            String name,
            String price,
            String description,
//            String categoryId,
//            String categoryName,
//            List<String> tags,
            String imageUrl
    ) {
    }
}
