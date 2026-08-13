package io.github.cupokki.chatkiosk26.order.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<?> checkout(@RequestBody OrderDto.CheckoutRequest req) {
        var res = orderService.checkout(req);
        return ResponseEntity.ok(res);
    }

    public ResponseEntity<?> getHistory() {
        var res = orderService.getHistory();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetail(@PathVariable("id") Long id) {
        var res = orderService.getDetail(id);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancel(@PathVariable("id")) {
        var res = orderService.cancel(id);
        return ResponseEntity.ok(res);
    }

    @PatchMapping()
    public ResponseEntity<?> update() {
        var res = orderService.update();
        return ResponseEntity.ok(res);
    }

    public Repon
}
