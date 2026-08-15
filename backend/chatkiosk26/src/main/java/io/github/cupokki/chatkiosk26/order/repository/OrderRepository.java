package io.github.cupokki.chatkiosk26.order.repository;

import io.github.cupokki.chatkiosk26.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
