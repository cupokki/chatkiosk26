package io.github.cupokki.chatkiosk26.store.controller;

import io.github.cupokki.chatkiosk26.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/v1/store")
@Slf4j
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

//    /**
//     * 전체 활성 매장 목록 조회
//     * @return
//     */
//    @GetMapping("")
//    public ResponseEntity<?> get() {
//        return ResponseEntity.ok().build();
//    }

//    /**
//     * 신규 매장 등록
//     * @return
//     */
//    @PostMapping("")
//    public ResponseEntity<?> get() {
//        return ResponseEntity.ok().build();
//    }

    /**
     * 매장별 카테고리 목록 조회
     * @param storeId
     * @return
     */
    @GetMapping("/{storeId:[0-9]+}/categories")
    public ResponseEntity<?> getCategories(@PathVariable Long storeId) {
        var res = storeService.getStoreCategories(storeId);
        return ResponseEntity.ok(res);
    }

    /**
     * 매장별 메뉴 목록 조회
     * @param storeId
     * @return
     */
    @GetMapping("/{storeId:[0-9]+}/menus")
    public ResponseEntity<?> getMenus(@PathVariable Long storeId) {
        var res = storeService.getStoreMenus(storeId);
        return ResponseEntity.ok(res);
    }

    /**
     * LangChain 대화형 장바구니 액션
     * @param storeId
     * @return
     */
    @PostMapping("/{storeId}/chat")
    public ResponseEntity<?> chat(@PathVariable String storeId) {
//        storeService.chat(storeId);
        return ResponseEntity.ok().build();
    }

    /**
     * 결제 완료 요청 스텁
     * @param storeId
     * @return
     */
    @PostMapping("/{storeId}/orders")
    public ResponseEntity<?> checkout(@PathVariable String storeId) {
        return ResponseEntity.ok().build();
    }
}
