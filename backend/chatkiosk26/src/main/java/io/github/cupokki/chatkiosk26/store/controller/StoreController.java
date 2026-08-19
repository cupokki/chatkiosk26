package io.github.cupokki.chatkiosk26.store.controller;

import io.github.cupokki.chatkiosk26.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
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
     * LangChain 대화형 장바구니 액션
     * @param storeId
     * @return
     */
    @PostMapping("/stores/{storeId}/chat")
    public ResponseEntity<?> chat(@PathVariable String storeId) {
//        storeService.chat(storeId);
        return ResponseEntity.ok().build();
    }

}
