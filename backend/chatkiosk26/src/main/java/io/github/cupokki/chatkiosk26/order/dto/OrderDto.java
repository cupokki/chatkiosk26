package io.github.cupokki.chatkiosk26.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {

    public record CheckoutRequest() {
    }

    public record salesPeriodRequest(
            Long storeId,
            LocalDateTime startAt,
            LocalDateTime endAt
    ) {
    }

    @Builder
    public record OrderItemResponse(
            Long itemId,
            String itemName,
            Long quantity,
            BigDecimal price
    ) { }

    @Builder
    public record OrderResponse(
            Long storeId,
            Long orderId,
            BigDecimal total,
            List<OrderItemResponse> orderItems, // ?? dto에서 하위 연관관계는 어케 처리하지?
            LocalDateTime createdAt,
            LocalDateTime orderedAt
//            String status
    ) {
    }
}
