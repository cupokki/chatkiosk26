package io.github.cupokki.chatkiosk26.order.controller;

import io.github.cupokki.chatkiosk26.order.dto.OrderDto;
import io.github.cupokki.chatkiosk26.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    /**
     * 결제 완료 요청 스텁
     * @param storeId
     * @return
     */
    @PostMapping("/stores/{storeId}/orders")
    public ResponseEntity<?> checkout(
            @PathVariable String storeId,
            @RequestBody OrderDto.CheckoutRequest checkoutRequest) {
        orderService.checkout(storeId, checkoutRequest);
        return ResponseEntity.ok().build();
    }
}
