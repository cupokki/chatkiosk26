package io.github.cupokki.chatkiosk26.category.service;

import io.github.cupokki.chatkiosk26.category.dto.CategoryDto;
import io.github.cupokki.chatkiosk26.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryDto.CategoriesResponse> getStoreCategories(Long storeId) {
//        return categoryRepository.findCategoryByStoreId(storeId);
        return categoryRepository.findTop5ByStoreId(storeId);
    }
}
