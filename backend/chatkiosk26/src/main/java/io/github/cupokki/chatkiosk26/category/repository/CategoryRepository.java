package io.github.cupokki.chatkiosk26.category.repository;

import io.github.cupokki.chatkiosk26.category.Category;
import io.github.cupokki.chatkiosk26.category.dto.CategoryDto;
import io.github.cupokki.chatkiosk26.store.dto.StoreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * 점포별 카테고리 목록 반환 (최대 5개로 제한)
     * @param storeId
     * @return
     */
    //    List<StoreDto.CategoriesResponse> findTop10ByStoreId(Long storeId);
//    @Query("SELECT c FROM Category c WHERE c.storeId = :storeId")
//    List<CategoryDto.CategoriesResponse> findCategoryByStoreId(@Param("storeId") Long storeId);

    List<CategoryDto.CategoriesResponse> findTop5ByStoreId(@Param("storeId") Long storeId);
}
