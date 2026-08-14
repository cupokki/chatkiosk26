package io.github.cupokki.chatkiosk26.order.dto;

import io.github.cupokki.chatkiosk26.order.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

//    @Mapping(source = "", target = "")
    Order toOrder(OrderDto.CheckoutRequest order);

    OrderDto toDto(Order order);
}
