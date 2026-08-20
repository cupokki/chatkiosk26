package io.github.cupokki.chatkiosk26.order.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.github.cupokki.chatkiosk26.order.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.ast.tree.expression.Collation;

import java.math.BigDecimal;
import java.util.List;

import static io.github.cupokki.chatkiosk26.order.QOrder.order;
import static io.github.cupokki.chatkiosk26.order.QOrderItem.orderItem;


@RequiredArgsConstructor
public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public BigDecimal findTotalSalesByPeriod(OrderDto.salesPeriodRequest request) {
        return jpaQueryFactory
                .select(orderItem.unitPrice.multiply(orderItem.quantity).sum())
                .from(order)
                .join(order.orderItems, orderItem)
                .where(
                        order.store.id.eq(request.storeId()),
                        order.orderedAt.between(request.startAt(), request.endAt())
//                        order.store.id.eq(request.storeId()),
//                        order.status.eq()
                ).fetchFirst();
    }

    @Override
    public List<OrderDto.OrderResponse> findOrderByPeriod(OrderDto.salesPeriodRequest request) {
        var orders = jpaQueryFactory
                .select(order)
                .from(order)
                .join(order.orderItems, orderItem)
                .where(
                        order.store.id.eq(request.storeId()),
                        order.orderedAt.between(request.startAt(), request.endAt())
//                        order.store.id.eq(request.storeId()),
//                        order.status.eq()
                ).fetchJoin();


        BigDecimal totalSales = orders.stream()
                .flatMap(o -> o.getOrderItems().stream())
                .map(oi -> oi.getUnitPrice().multiply(BigDecimal.valueOf(oi.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return orders.stream()
                .map(o -> OrderDto.OrderResponse.builder()
                        .storeId(o.getStore().getId())
                        .orderId(o.getId())
                        .total(totalSales)
                        .orderItems(o.getOrderItems().stream()
                                .map(oi -> OrderDto.OrderItemResponse.builder()
                                        .itemId(oi.getMenu().getId())
                                        .itemName(oi.getMenu().getName())
                                        .quantity(oi.getQuantity())
                                        .price(oi.getUnitPrice())
                                        .build()).toList())
                .orderedAt(o.getOrderedAt())
                .createdAt(o.getCreateAt())
                .build()).toList();
    }
}
