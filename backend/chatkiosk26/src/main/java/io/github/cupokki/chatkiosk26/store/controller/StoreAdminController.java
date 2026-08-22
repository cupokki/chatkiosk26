package io.github.cupokki.chatkiosk26.store.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class StoreAdminController {
    /**
     * 신규 메뉴 등록
     * @param storeId
     * @return
     */
    @GetMapping("/admin/stores/{storeId}/categories")
    public ResponseEntity<?> getCategories(@PathVariable String storeId) {
        return ResponseEntity.ok().build();
    }

    /**
     * QueryDSL 동적 메뉴 검색
     * @param storeId
     * @return
     */
    @GetMapping("/admin/stores/{storeId}/menus")
    public ResponseEntity<?> getMenus(@PathVariable String storeId) {
        return ResponseEntity.ok().build();
    }

    /**
     * 메뉴 정보 및 판매 상태(available) 수정
     * @param storeId
     * @param menuId
     * @return
     */
    @PatchMapping("/admin/stores/{storeId}/menus/{menuId}")
    public ResponseEntity<?> chat(@PathVariable String storeId, @PathVariable String menuId) {
        return ResponseEntity.ok().build();
    }

    /**
     * 메뉴 소프트 딜리트
     * @param storeId
     * @param menuId
     * @return
     */
    @DeleteMapping("/{storeId}/menus/{menuId}")
    public ResponseEntity<?> deleteMenu(@PathVariable String storeId, @PathVariable String menuId) {
        return ResponseEntity.ok().build();
    }

    /**
     * 기간/카테고리별 매출 통계 조회
     * @param storeId
     * @return
     */
    @GetMapping("/{storeId}/statistics")
    public ResponseEntity<?> checkout(@PathVariable String storeId) {
        return ResponseEntity.ok().build();
    }

    /**
     * 태그 목록 조회
     * @param storeId
     * @return
     */
    @GetMapping("/{storeId}/tags")
    public ResponseEntity<?> getTags(@PathVariable String storeId) {
        return ResponseEntity.ok().build();
    }

}
