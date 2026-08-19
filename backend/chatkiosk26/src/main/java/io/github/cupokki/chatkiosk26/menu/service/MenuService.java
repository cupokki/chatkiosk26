package io.github.cupokki.chatkiosk26.category.service;

import io.github.cupokki.chatkiosk26.menu.dto.MenuDto;
import io.github.cupokki.chatkiosk26.menu.repository.MenuRepository;
import io.github.cupokki.chatkiosk26.store.dto.StoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public List<MenuDto.StoreMenusResponse> getStoreMenus(Long storeId) {
        return menuRepository.findMenusByStoreId(storeId);
    }
}
