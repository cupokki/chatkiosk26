package io.github.cupokki.chatkiosk26.category.controller;

import io.github.cupokki.chatkiosk26.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    /**
     * 매장별 카테고리 목록 조회
     * @param storeId
     * @return
     */
    @GetMapping("/stores/{storeId:[0-9]+}/categories")
    public ResponseEntity<?> getCategories(@PathVariable Long storeId) {
        var res = categoryService.getStoreCategories(storeId);
        return ResponseEntity.ok(res);
    }
}
