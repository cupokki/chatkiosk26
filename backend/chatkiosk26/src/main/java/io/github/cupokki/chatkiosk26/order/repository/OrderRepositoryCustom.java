package io.github.cupokki.chatkiosk26.order.repository;

import io.github.cupokki.chatkiosk26.order.dto.OrderDto;

import java.math.BigDecimal;
import java.util.List;

public interface OrderRepositoryCustom {

    BigDecimal findTotalSalesByPeriod(OrderDto.salesPeriodRequest request);

    List<OrderDto.OrderResponse> findOrderByPeriod(OrderDto.salesPeriodRequest request);
}
