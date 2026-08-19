package io.github.cupokki.chatkiosk26.menu.controller;

import io.github.cupokki.chatkiosk26.category.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class MenuController {

    private final MenuService menuService;

    /**
     * 매장별 메뉴 목록 조회
     * @param storeId
     * @return
     */
    @GetMapping("/stores/{storeId:[0-9]+}/menus")
    public ResponseEntity<?> getMenus(@PathVariable Long storeId) {
        var res = menuService.getStoreMenus(storeId);
        return ResponseEntity.ok(res);
    }
}
