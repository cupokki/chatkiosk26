package io.github.cupokki.chatkiosk26.order.service;

import io.github.cupokki.chatkiosk26.order.dto.OrderDto;
import io.github.cupokki.chatkiosk26.order.dto.OrderMapper;
import io.github.cupokki.chatkiosk26.order.Order;
import io.github.cupokki.chatkiosk26.order.repository.OrderRepository;
import io.github.cupokki.chatkiosk26.store.dto.StoreDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    /** 주문 생성 */
    public void getOrderDetails(Long id) {
//        orderRepository.getReferenceById(id);
    }


    /** 주문 결제 요청 */
    public void checkout(String storeId, OrderDto.CheckoutRequest request) {
        return;
    }

    public void getSalesByPeriod (OrderDto.salesPeriodRequest request) {
        orderRepository.findTotalSalesByPeriod(request);
        return;
    }




}
