package io.github.cupokki.chatkiosk26.store.dto;

public class StoreDto {

    public record DetailResponse(
            Long id,
            String name,
            String detail
    ) {
    }


    public record CategoriesResponse(
            Long id
    ) {
    }

    public record MenusResponse(
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
