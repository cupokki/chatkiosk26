package io.github.cupokki.chatkiosk26.order.service;

import io.github.cupokki.chatkiosk26.order.dto.OrderDto;
import io.github.cupokki.chatkiosk26.order.dto.OrderMapper;
import io.github.cupokki.chatkiosk26.order.repository.Order;
import io.github.cupokki.chatkiosk26.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public void getOrderDetails(Long id) {
        orderRepository.getReferenceById(id);
    }

    @Transactional
    public void checkout(OrderDto.CheckoutRequest req) {
        Order order = orderMapper.toOrder(req);
        orderRepository.save(order);
    }
}
