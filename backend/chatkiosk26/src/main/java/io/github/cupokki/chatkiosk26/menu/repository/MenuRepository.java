package io.github.cupokki.chatkiosk26.menu.repository;

import io.github.cupokki.chatkiosk26.menu.Menu;
import io.github.cupokki.chatkiosk26.menu.dto.MenuDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<MenuDto.StoreMenusResponse> findMenusByStoreId(Long storeId);
}
